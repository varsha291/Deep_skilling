import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry, tap } from 'rxjs/operators';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private apiUrl = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) { }

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      retry(2),
      map(courses => courses.filter(course => course.credits > 0)),
      // tap is for side effects such as logging; map stays responsible for changing stream values.
      tap(courses => console.log('Courses loaded:', courses.length)),
      catchError(error => {
        console.error(error);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      retry(2),
      catchError(error => {
        console.error(error);
        return throwError(() => new Error('Failed to load the selected course.'));
      })
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course).pipe(
      catchError(error => {
        console.error(error);
        return throwError(() => new Error('Failed to create course.'));
      })
    );
  }

  updateCourse(id: number, course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

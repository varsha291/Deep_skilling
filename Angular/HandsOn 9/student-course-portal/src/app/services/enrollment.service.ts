import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { forkJoin, map, Observable, of, switchMap } from 'rxjs';
import { Student } from '../models/student';

interface Enrollment {
  id: number;
  courseId: number;
  studentId: number;
}

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private apiUrl = 'http://localhost:3000/enrollments';
  private studentsUrl = 'http://localhost:3000/students';

  constructor(private http: HttpClient) { }

  getEnrollments(): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(this.apiUrl);
  }

  enroll(data: Omit<Enrollment, 'id'>): Observable<Enrollment> {
    return this.http.post<Enrollment>(this.apiUrl, data);
  }

  updateEnrollment(id: number, data: Omit<Enrollment, 'id'>): Observable<Enrollment> {
    return this.http.put<Enrollment>(`${this.apiUrl}/${id}`, data);
  }

  deleteEnrollment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getStudentsByCourse(courseId: number): Observable<Student[]> {
    return this.http.get<Enrollment[]>(`${this.apiUrl}?courseId=${courseId}`).pipe(
      map(enrollments => enrollments.map(enrollment => enrollment.studentId)),
      switchMap(studentIds => {
        if (!studentIds.length) {
          return of([]);
        }

        return forkJoin(
          studentIds.map(studentId => this.http.get<Student>(`${this.studentsUrl}/${studentId}`))
        );
      })
    );
  }
}

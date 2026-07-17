import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BehaviorSubject, Observable, of, switchMap } from 'rxjs';
import { Course } from './models/course';
import { Student } from './models/student';
import { CourseService } from './services/course.service';
import { EnrollmentService } from './services/enrollment.service';
import { LoadingService } from './services/loading.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'student-course-portal';
  courses: Course[] = [];
  selectedCourseId: number | null = null;
  selectedStudents$: Observable<Student[]>;
  errorMessage = '';
  successMessage = '';
  isLoading = false;

  courseForm: Omit<Course, 'id'> = this.getEmptyCourse();
  private selectedCourseIdSubject = new BehaviorSubject<number | null>(null);

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    public loadingService: LoadingService
  ) {
    this.selectedStudents$ = this.selectedCourseIdSubject.pipe(
      // switchMap cancels the previous student request when a new course id arrives, preventing stale responses.
      switchMap(courseId => courseId ? this.enrollmentService.getStudentsByCourse(courseId) : of([]))
    );
  }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.isLoading = true;
    this.errorMessage = '';

    this.courseService.getCourses().subscribe({
      next: courses => {
        this.courses = courses;
        if (!this.selectedCourseId && courses.length) {
          this.selectCourse(courses[0].id);
        }
      },
      error: error => {
        this.errorMessage = error.message;
        this.isLoading = false;
      },
      complete: () => this.isLoading = false
    });
  }

  createCourse(): void {
    this.errorMessage = '';
    this.successMessage = '';

    this.courseService.createCourse(this.courseForm).subscribe({
      next: course => {
        this.courses = [...this.courses, course];
        this.courseForm = this.getEmptyCourse();
        this.successMessage = 'Course created successfully.';
      },
      error: error => this.errorMessage = error.message
    });
  }

  markComplete(course: Course): void {
    const updatedCourse: Omit<Course, 'id'> = {
      ...course,
      progress: 100
    };

    this.courseService.updateCourse(course.id, updatedCourse).subscribe({
      next: savedCourse => {
        this.courses = this.courses.map(item => item.id === savedCourse.id ? savedCourse : item);
        this.successMessage = `${savedCourse.title} marked complete.`;
      },
      error: error => this.errorMessage = error.message
    });
  }

  deleteCourse(courseId: number): void {
    this.courseService.deleteCourse(courseId).subscribe({
      next: () => {
        this.courses = this.courses.filter(course => course.id !== courseId);
        if (this.selectedCourseId === courseId) {
          this.selectCourse(this.courses[0]?.id ?? null);
        }
        this.successMessage = 'Course deleted successfully.';
      },
      error: error => this.errorMessage = error.message
    });
  }

  selectCourse(courseId: number | null): void {
    this.selectedCourseId = courseId;
    this.selectedCourseIdSubject.next(courseId);
  }

  private getEmptyCourse(): Omit<Course, 'id'> {
    return {
      title: '',
      instructor: '',
      duration: '',
      category: '',
      credits: 1,
      progress: 0
    };
  }
}

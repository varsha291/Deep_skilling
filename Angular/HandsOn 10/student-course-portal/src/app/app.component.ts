import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Store } from '@ngrx/store';
import { BehaviorSubject, Observable, of, switchMap } from 'rxjs';
import { Course } from './models/course';
import { Student } from './models/student';
import { CourseService } from './services/course.service';
import { EnrollmentService } from './services/enrollment.service';
import { LoadingService } from './services/loading.service';
import { AppState } from './store/app.state';
import { CourseActions } from './store/course.actions';
import { selectAllCourses, selectCourseError, selectCourseLoading, selectSelectedCourseId } from './store/course.selectors';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'student-course-portal';
  selectedCourseId: number | null = null;
  isLoading = false;
  selectedStudents$: Observable<Student[]>;
  courses$: Observable<Course[]>;
  selectedCourseId$: Observable<number | null>;
  isLoading$: Observable<boolean>;
  errorMessage$: Observable<string | null>;
  successMessage = '';

  courseForm: Omit<Course, 'id'> = this.getEmptyCourse();
  private selectedCourseIdSubject = new BehaviorSubject<number | null>(null);

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    public loadingService: LoadingService,
    private store: Store<AppState>
  ) {
    this.selectedStudents$ = this.selectedCourseIdSubject.pipe(
      // switchMap cancels the previous student request when a new course id arrives, preventing stale responses.
      switchMap(courseId => courseId ? this.enrollmentService.getStudentsByCourse(courseId) : of([]))
    );

    this.courses$ = this.store.select(selectAllCourses);
    this.selectedCourseId$ = this.store.select(selectSelectedCourseId);
    this.isLoading$ = this.store.select(selectCourseLoading);
    this.errorMessage$ = this.store.select(selectCourseError);

    this.store.select(selectAllCourses).subscribe(courses => {
      if (!this.selectedCourseId && courses.length) {
        this.selectCourse(courses[0].id);
      }
    });

    this.store.select(selectSelectedCourseId).subscribe(courseId => {
      this.selectedCourseId = courseId;
      this.selectedCourseIdSubject.next(courseId);
    });

    this.store.select(selectCourseLoading).subscribe(loading => {
      this.isLoading = loading;
    });
  }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.store.dispatch(CourseActions.loadCourses());
  }

  createCourse(): void {
    this.successMessage = '';

    this.store.dispatch(CourseActions.createCourse({ course: this.courseForm }));
    this.courseForm = this.getEmptyCourse();
    this.successMessage = 'Course created successfully.';
  }

  markComplete(course: Course): void {
    const updatedCourse: Omit<Course, 'id'> = {
      ...course,
      progress: 100
    };

    this.store.dispatch(CourseActions.updateCourse({ courseId: course.id, course: updatedCourse }));
    this.successMessage = `${course.title} marked complete.`;
  }

  deleteCourse(courseId: number): void {
    this.store.dispatch(CourseActions.deleteCourse({ courseId }));
    this.successMessage = 'Course deleted successfully.';
  }

  selectCourse(courseId: number | null): void {
    this.store.dispatch(CourseActions.selectCourse({ courseId }));
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

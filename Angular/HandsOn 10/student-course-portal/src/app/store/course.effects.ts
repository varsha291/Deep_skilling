import { Injectable, inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, map, mergeMap, of } from 'rxjs';
import { CourseService } from '../services/course.service';
import { CourseActions } from './course.actions';

@Injectable()
export class CourseEffects {
  private actions$ = inject(Actions);
  private courseService = inject(CourseService);

  loadCourses$ = createEffect(() => this.actions$.pipe(
    ofType(CourseActions.loadCourses),
    mergeMap(() => this.courseService.getCourses().pipe(
      map(courses => CourseActions.loadCoursesSuccess({ courses })),
      catchError(error => of(CourseActions.loadCoursesFailure({ error: error.message })))
    ))
  ));

  createCourse$ = createEffect(() => this.actions$.pipe(
    ofType(CourseActions.createCourse),
    mergeMap(({ course }) => this.courseService.createCourse(course).pipe(
      map(createdCourse => CourseActions.createCourseSuccess({ course: createdCourse })),
      catchError(error => of(CourseActions.createCourseFailure({ error: error.message })))
    ))
  ));

  updateCourse$ = createEffect(() => this.actions$.pipe(
    ofType(CourseActions.updateCourse),
    mergeMap(({ courseId, course }) => this.courseService.updateCourse(courseId, course).pipe(
      map(updatedCourse => CourseActions.updateCourseSuccess({ course: updatedCourse })),
      catchError(error => of(CourseActions.updateCourseFailure({ error: error.message })))
    ))
  ));

  deleteCourse$ = createEffect(() => this.actions$.pipe(
    ofType(CourseActions.deleteCourse),
    mergeMap(({ courseId }) => this.courseService.deleteCourse(courseId).pipe(
      map(() => CourseActions.deleteCourseSuccess({ courseId })),
      catchError(error => of(CourseActions.deleteCourseFailure({ error: error.message })))
    ))
  ));
}

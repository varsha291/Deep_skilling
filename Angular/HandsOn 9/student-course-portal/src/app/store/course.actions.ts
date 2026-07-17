import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { Course } from '../models/course';

export const CourseActions = createActionGroup({
  source: 'Course',
  events: {
    'Load Courses': emptyProps(),
    'Load Courses Success': props<{ courses: Course[] }>(),
    'Load Courses Failure': props<{ error: string }>(),
    'Select Course': props<{ courseId: number | null }>(),
    'Create Course': props<{ course: Omit<Course, 'id'> }>(),
    'Create Course Success': props<{ course: Course }>(),
    'Create Course Failure': props<{ error: string }>(),
    'Update Course': props<{ courseId: number; course: Omit<Course, 'id'> }>(),
    'Update Course Success': props<{ course: Course }>(),
    'Update Course Failure': props<{ error: string }>(),
    'Delete Course': props<{ courseId: number }>(),
    'Delete Course Success': props<{ courseId: number }>(),
    'Delete Course Failure': props<{ error: string }>()
  }
});

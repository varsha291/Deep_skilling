import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CourseState } from './app.state';

export const selectCourseState = createFeatureSelector<CourseState>('courses');

export const selectAllCourses = createSelector(
  selectCourseState,
  state => state.items
);

export const selectSelectedCourseId = createSelector(
  selectCourseState,
  state => state.selectedCourseId
);

export const selectCourseLoading = createSelector(
  selectCourseState,
  state => state.loading
);

export const selectCourseError = createSelector(
  selectCourseState,
  state => state.error
);

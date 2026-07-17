import { createReducer, on } from '@ngrx/store';
import { CourseState } from './app.state';
import { CourseActions } from './course.actions';

const initialState: CourseState = {
  items: [],
  selectedCourseId: null,
  loading: false,
  error: null
};

export const courseReducer = createReducer(
  initialState,
  on(CourseActions.loadCourses, state => ({ ...state, loading: true, error: null })),
  on(CourseActions.loadCoursesSuccess, (state, { courses }) => ({
    ...state,
    items: courses,
    loading: false,
    error: null
  })),
  on(CourseActions.loadCoursesFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  })),
  on(CourseActions.selectCourse, (state, { courseId }) => ({
    ...state,
    selectedCourseId: courseId
  })),
  on(CourseActions.createCourseSuccess, (state, { course }) => ({
    ...state,
    items: [...state.items, course],
    loading: false,
    error: null
  })),
  on(CourseActions.createCourseFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  })),
  on(CourseActions.updateCourseSuccess, (state, { course }) => ({
    ...state,
    items: state.items.map(item => item.id === course.id ? course : item),
    loading: false,
    error: null
  })),
  on(CourseActions.updateCourseFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  })),
  on(CourseActions.deleteCourseSuccess, (state, { courseId }) => ({
    ...state,
    items: state.items.filter(item => item.id !== courseId),
    loading: false,
    error: null
  })),
  on(CourseActions.deleteCourseFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  }))
);

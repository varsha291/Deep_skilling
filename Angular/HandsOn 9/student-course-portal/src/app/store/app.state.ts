import { Course } from '../models/course';

export interface CourseState {
  items: Course[];
  selectedCourseId: number | null;
  loading: boolean;
  error: string | null;
}

export interface AppState {
  courses: CourseState;
}

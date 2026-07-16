import { Component } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css'
})
export class CourseSummaryWidget {

  constructor(private courseService: CourseService) {}

  get courseCount(): number {
    return this.courseService.getCourses().length;
  }

  addCourse(): void {
    this.courseService.addCourse({
      id: 6,
      name: 'Spring Boot',
      code: 'SPR101',
      credits: 4,
      gradeStatus: 'pending'
    });
  }
}
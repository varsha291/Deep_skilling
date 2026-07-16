import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {
  selectedCourseId: number | null = null;

  courses = [
    { id: 1, name: 'Angular', code: 'ANG101', credits: 4 },
    { id: 2, name: 'React', code: 'REA101', credits: 3 },
    { id: 3, name: 'Java', code: 'JAVA101', credits: 4 },
    { id: 4, name: 'Python', code: 'PY101', credits: 3 },
    { id: 5, name: 'Database', code: 'DB101', credits: 4 }
  ];

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';

@Component({
  selector: 'app-course-list',
  imports: [
    CommonModule,
    CourseCard,
    Highlight
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  selectedCourseId: number | null = null;
  isLoading = true;

  courses = [
    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: true
    },
    {
      id: 2,
      name: 'React',
      code: 'REA101',
      credits: 3,
      gradeStatus: 'failed',
      enrolled: false
    },
    {
      id: 3,
      name: 'Java',
      code: 'JAVA101',
      credits: 4,
      gradeStatus: 'pending',
      enrolled: true
    },
    {
      id: 4,
      name: 'Python',
      code: 'PY101',
      credits: 1,
      gradeStatus: 'passed',
      enrolled: false
    },
    {
      id: 5,
      name: 'Database',
      code: 'DB101',
      credits: 0,
      gradeStatus: 'pending',
      enrolled: false
    }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  // trackBy improves performance by reusing unchanged DOM elements.
  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}
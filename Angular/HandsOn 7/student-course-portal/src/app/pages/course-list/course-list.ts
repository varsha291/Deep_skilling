import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';

import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';
import { CourseService } from '../../services/course';
import { EnrollmentService } from '../../services/enrollment';

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

  courses: any[] = [];

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.courses = this.courseService.getCourses();

    setTimeout(() => {
      this.isLoading = false;
    }, 1500);

    const search =
      this.route.snapshot.queryParamMap.get('search');

    if (search) {
      console.log('Search:', search);
    }

  }

  onEnroll(courseId: number): void {

    this.enrollmentService.enroll(courseId);

    this.selectedCourseId = courseId;

  }

  openCourse(id: number): void {

    this.router.navigate(
      ['courses', id]
    );

  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

}
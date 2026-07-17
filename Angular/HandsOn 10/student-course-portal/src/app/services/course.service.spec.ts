import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { CourseService } from './course.service';
import { Course } from '../models/course';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get courses from the API', () => {
    const mockCourses: Course[] = [
      {
        id: 1,
        title: 'Data Structures',
        instructor: 'Dr. Rao',
        duration: '8 weeks',
        category: 'Computer Science',
        credits: 4,
        progress: 100
      },
      {
        id: 2,
        title: 'Angular Fundamentals',
        instructor: 'Ms. Kumar',
        duration: '6 weeks',
        category: 'Web Development',
        credits: 3,
        progress: 50
      }
    ];

    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
    });

    const request = httpMock.expectOne('http://localhost:3000/courses');
    expect(request.request.method).toBe('GET');
    request.flush(mockCourses);
  });

  it('should return an error when getCourses fails', () => {
    service.getCourses().subscribe({
      next: () => fail('Expected an error, not courses'),
      error: error => {
        expect(error.message).toBe('Failed to load courses. Please try again.');
      }
    });

    for (let attempt = 0; attempt < 3; attempt++) {
      const request = httpMock.expectOne('http://localhost:3000/courses');
      request.flush('Server error', {
        status: 500,
        statusText: 'Internal Server Error'
      });
    }
  });
});

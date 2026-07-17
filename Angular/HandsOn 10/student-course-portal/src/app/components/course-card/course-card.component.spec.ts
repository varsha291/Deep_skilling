import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SimpleChange } from '@angular/core';
import { By } from '@angular/platform-browser';

import { CourseCardComponent } from './course-card.component';

describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display the course name from input', () => {
    component.course = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed'
    };

    fixture.detectChanges();

    const heading = fixture.debugElement.query(By.css('h3')).nativeElement;
    expect(heading.textContent).toContain('Data Structures');
  });

  it('should emit course id when enroll button is clicked', () => {
    const mockCourse = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed'
    };

    component.course = mockCourse;
    fixture.detectChanges();
    spyOn(component.enrollRequested, 'emit');

    fixture.debugElement.query(By.css('button')).nativeElement.click();
    fixture.detectChanges();

    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });

  it('should log course input changes in ngOnChanges', () => {
    const mockCourse = {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed'
    };
    spyOn(console, 'log');

    component.ngOnChanges({
      course: new SimpleChange(null, mockCourse, true)
    });

    expect(console.log).toHaveBeenCalledWith('Course input changed:', mockCourse);
  });
});

import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

export interface CourseCard {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: string;
}

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course: CourseCard | null = null;
  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Course input changed:', changes['course'].currentValue);
    }
  }

  requestEnrollment(): void {
    if (this.course) {
      this.enrollRequested.emit(this.course.id);
    }
  }
}

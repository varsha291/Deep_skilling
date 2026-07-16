import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  imports: [
    CommonModule,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input() course!: {
    id: number;
    name: string;
    code: string;
    credits: number | null;
    gradeStatus: string;
    enrolled: boolean;
  };

  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'Previous course:',
        changes['course'].previousValue
      );

      console.log(
        'Current course:',
        changes['course'].currentValue
      );
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  get borderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed':
        return 'green';

      case 'failed':
        return 'red';

      default:
        return 'grey';
    }
  }

  // Getter keeps complex ngClass logic out of the template.
  get cardClasses() {
    return {
      'card--enrolled': this.course.enrolled,
      'card--full': (this.course.credits ?? 0) >= 4,
      'expanded': this.isExpanded
    };
  }
}
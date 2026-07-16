import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';

function noCourseCode(
  control: AbstractControl
): ValidationErrors | null {
  const value = control.value;

  if (
    value &&
    value.toString().toUpperCase().startsWith('XX')
  ) {
    return { noCourseCode: true };
  }

  return null;
}

function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {
  return new Promise(resolve => {
    setTimeout(() => {
      const email = control.value || '';

      if (email.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm implements OnInit {

  enrollForm: any;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      studentEmail: this.fb.control(
        '',
        [
          Validators.required,
          Validators.email
        ],
        [simulateEmailCheck]
      ),

      courseId: [
        '',
        [
          Validators.required,
          noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])
    });
  }

  get additionalCourses(): FormArray {
    return this.enrollForm.get(
      'additionalCourses'
    ) as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(
      this.fb.control(
        '',
        Validators.required
      )
    );
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    console.log(
      'Form Value:',
      this.enrollForm.value
    );

    console.log(
      'Raw Form Value:',
      this.enrollForm.getRawValue()
    );

    // enrollForm.value excludes disabled controls.
    // getRawValue() includes all controls,
    // including disabled controls.
  }
}
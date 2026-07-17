import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { CourseSummaryWidget } from './components/course-summary-widget/course-summary-widget';
import { Notification } from './components/notification/notification';
import { Header } from './components/header/header';
import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollmentForm } from './pages/reactive-enrollment-form/reactive-enrollment-form';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    Header,
    Home,
    CourseList,
    EnrollmentForm,
    CourseSummaryWidget,
    Notification,
    ReactiveEnrollmentForm
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}
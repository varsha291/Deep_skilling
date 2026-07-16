import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [],
  templateUrl: './notification.html',
  styleUrl: './notification.css',

  // Component-level provider creates a separate service instance
  // scoped to this component and its children.
  providers: [NotificationService]
})
export class Notification {

  constructor(
    public notificationService: NotificationService
  ) {}
}
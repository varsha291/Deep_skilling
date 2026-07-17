import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {

  message = 'Notification service instance created';

  getMessage(): string {
    return this.message;
  }
}
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Auth {

  isLoggedIn = true;

  login() {
    this.isLoggedIn = true;
  }

  logout() {
    this.isLoggedIn = false;
  }

}
import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserIDService} from '../services/http.IDservice';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent {
  isLogged = this.userInfo.isLogged;
  isAdmin = this.userInfo.isAdmin;
  loginn = this.userInfo.login;
  password = this.userInfo.password;
  title = 'MySite';

  constructor(private userInfo: UserIDService) {}

}

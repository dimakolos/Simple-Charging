import {Component, OnInit} from '@angular/core';
import {UserIDService} from '../services/http.IDservice';
import {HttpAuthUser} from '../services/http.AuthUser';
import {LoggedUser} from '../model/LoggedUser';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  private login: any;

  constructor(private userInfo: UserIDService, private logUser: LoggedUser) {
  }

  quitclick() {
    this.userInfo.isLogged = false;
    this.userInfo.isAdmin = false;
  }

}

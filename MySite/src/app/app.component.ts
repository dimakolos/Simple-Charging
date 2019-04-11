import {Component, OnChanges} from '@angular/core';
import {UserIDService} from './services/http.IDservice';
import {HttpService} from './services/http.service';
import {LoggedUser} from './model/LoggedUser';
import {UserModel} from './model/UserModel';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent implements OnChanges {
  isLogged = this.userInfo.isLogged;
  isAdmin = this.userInfo.isAdmin;
  title = 'MySite';
  login = '';
  password = '';
  private logged: boolean;
  private loginedUser: any;
  user: UserModel;

  constructor(private userInfo: UserIDService, private http: HttpService, private logUser: LoggedUser) {
  }

  adminclick() {
    this.userInfo.isAdmin = true;
    this.userInfo.isLogged = true;
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }

  userclick() {
    this.http.authUser(this.login, this.password).subscribe((user) => {
      this.logUser.setUser(user);
      if (this.logUser.getUser() != null) {
        this.logged = true;
        this.userInfo.isLogged = true;
        this.isLogged = this.userInfo.isLogged;
        console.log(this.logUser.getSubscriptions());
      }
     });
    }

  registerclick() {
      this.userInfo.isLogged = true;
      this.isLogged = this.userInfo.isLogged;
  }

  refresh(logged) {
    this.logged = logged;
    this.userInfo.isLogged = this.logged;
    this.isLogged = this.userInfo.isLogged;
  }

  ngOnChanges() {
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }
}

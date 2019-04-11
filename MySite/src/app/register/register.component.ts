import {Component} from '@angular/core';
import {HttpService} from '../services/http.service';
import {UserModel} from '../model/UserModel';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {Subscription} from 'rxjs';
import {UserIDService} from '../services/http.IDservice';

@Component ({
  selector: 'register-app',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  private repeatPassword: string;

  constructor(private user: UserModel, private http: HttpService,
  private spinnerService: Ng4LoadingSpinnerService, private userInfo: UserIDService) {
    this.user.login = '';
    this.user.password = '';
    this.user.balance = '0';
    this.repeatPassword = '';
  }

  public toRegister() {
    this.spinnerService.show();
    let userModel = this.user;
    this.http.setUser(userModel).subscribe(() => {
      this.spinnerService.hide();
      this.userInfo.isLogged = false;
      this.userInfo.isAdmin = false;
    });
  }
}

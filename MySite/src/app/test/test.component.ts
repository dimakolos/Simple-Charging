import { Component, OnInit } from '@angular/core';
import {HttpService} from '../services/http.service';
import {UserIDService} from '../services/http.IDservice';
import {UserModel} from '../model/UserModel';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {Subscription} from 'rxjs/internal/Subscription';



@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public subscriptions: any[];
  public users: any[];
  public val = false;
  private subscription: Subscription[] = [];

  constructor(private http: HttpService, private spinnerService: Ng4LoadingSpinnerService) {
    http.getSubscriptions()
      .subscribe(subscriptions => this.subscriptions = subscriptions);
    http.getUsers()
      .subscribe(users => this.users = users);
  }

  contains(): boolean {
    let array = [];
    return !(array.indexOf(2) === -1);
  }

  ngOnInit() {
  }
  sendPost() {
    this.spinnerService.show();
    let userModel = new UserModel();
    userModel.login = 'dima';
    userModel.password = '123456';
    userModel.balance = '100';
    this.subscription.push(this.http.setUser(userModel).subscribe(() =>
    this.spinnerService.hide()));
    this.val = true;
  }
}

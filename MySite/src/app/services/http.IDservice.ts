import {BehaviorSubject, Observable} from 'rxjs';
import {Injectable, Input} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class UserIDService {
  public login = 'Petya';
  public password = 'password';
  public balance = 10;
  public subscriptions = ['powerpoint'];
  public isLogged = false;
  public name = 'Dimass';
  public surname =  'Kolosss';
  public birthday = '17.03.1999';
  public email = 'petya@gmail.com';
  public isAdmin = false;
  public blocked = false;

  constructor (private http: HttpClient) {
  }
}

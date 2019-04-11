import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {UserIDService} from './http.IDservice';
import {UserModel} from '../model/UserModel';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getSubscriptions(): Observable<any> {
    return this.http.get('http://localhost:8081/api/subscriptions/')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  getUsers(): Observable<any> {
    return this.http.get('http://localhost:8081/api/users/')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  deleteSubscription(id: string): Observable<any> {
    return this.http.get('../assets/subscriptions.json', {params: {id}})
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  authUser(login: string, password: string): Observable<any> {
    console.log('authenfication');
    return this.http.get('http://localhost:8081/api/signin?login=' + login + '&password=' + password);
  }

  setUser(user: UserModel): Observable<UserModel> {
    console.log('new user');
    return this.http.post<UserModel>('http://localhost:8081/api/', user);
  }

  subscribeUser(user: UserModel, id_subscription: any): Observable<any> {
    console.log('subscribeUser');
    return this.http.post<UserModel>('http://localhost:8081/api/join?id_subscription=' + id_subscription, user);
  }

  unsubscribeUser(user: UserModel, id_subscription: any): Observable<any> {
    console.log('unsubscribeUser');
    return this.http.post<UserModel>('http://localhost:8081/api/refuse?&id_subscription=' + id_subscription, user);
  }

  updateUser(id_user: any): Observable<any> {
    console.log('updating...');
    return this.http.get('http://localhost:8081/api/user_update?id_user=' + id_user);
  }

  addBalance(id_user: any, balance: any): Observable<any> {
    console.log('adding balance');
    return this.http.get('http://localhost:8081/api/add_balance?id_user=' + id_user + '&balance=' + balance);
  }
}

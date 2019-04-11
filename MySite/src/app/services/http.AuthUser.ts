import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable ({
  providedIn: 'root'
})
export class HttpAuthUser {
  constructor (private http: HttpClient) { }

  getBalance(): Observable<any> {
    return this.http.get('http//localhost:8081/api/balance')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  setBalance(balance: number): Observable<any> {
    return this.http.post<number>('http//localhost:8081/api/password', balance);
  }

  getLogin(): Observable<any> {
    return this.http.get('http//localhost:8081/api/login')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  setLogin(login: string): Observable<any> {
    return this.http.post<string>('http//localhost:8081/api/password', login);
  }

  getPassword(): Observable<any> {
    return this.http.get('http//localhost:8081/api/password')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }

  setPassword(password: string): Observable<any> {
    return this.http.post<string>('http//localhost:8081/api/password', password);
  }


}

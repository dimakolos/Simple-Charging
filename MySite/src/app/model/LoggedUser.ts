import {Injectable} from '@angular/core';
import {UserModel} from './UserModel';

@Injectable({
  providedIn: 'root'
})
export class LoggedUser {
  private user: UserModel;

  getId() {
    return this.user.id;
  }

  getUser() {
    return this.user;
  }

  setUser(user: UserModel) {
    this.user = user;
  }

  getLogin() {
    return this.user.login;
  }

  getBalance() {
    return this.user.balance;
  }

  setBalance(balance: any) {
    this.user.balance = balance;
  }

  getSubscriptions() {
    return this.user.subscriptions;
  }

  setSubcrirptions(subs: any[]) {
    this.user.subscriptions = subs;
  }

  addSubscription(sub: any) {
    this.user.subscriptions.push(sub);
  }

  deleteSubscription(id: any) {
    for (let i = 0; i < this.user.subscriptions.length; i++) {
      if (this.user.subscriptions[i].id === id) {
        let subscription = this.user.subscriptions[i];
        this.user.subscriptions = this.user.subscriptions.filter(sub => sub !== subscription);
      }
    }
  }
}

import {Component, OnChanges, OnInit} from '@angular/core';
import {HttpService} from '../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';
import {LoggedUser} from '../model/LoggedUser';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {
  public allSubs: any[] = [];
  public displayedSubs: any[] = [];
  public subs: any[];
  public formatter: boolean;
  public search = '';

  constructor(private http: HttpService, private userInfo: UserIDService, private logUser: LoggedUser) {
    this.formatter = null;
  }

  ngOnInit() {
    this.http.getSubscriptions().subscribe(subscriptions => {
      this.allSubs = subscriptions;
      this.displayedSubs = JSON.parse(JSON.stringify(this.allSubs));
    }, err => {
      console.log(err);
    });
  }

  filter(data: Array<any>): Array<any> {
    return data.filter((sub) => {
      return (sub['name'] as string).includes(this.search);
    });
  }

  showSubscribed(): void {
    this.http.getSubscriptions().subscribe((data: Array<any>) => {
      this.displayedSubs = this.logUser.getSubscriptions();
    });
  }

  showUnsubscribed() {
    this.displayedSubs = this.allSubs.filter((sub) => {
      return this.logUser.getSubscriptions().find((element) => {
        return element['name'] === sub['name'];
      }) === undefined;
    });
  }

  showAll() {
    this.http.getSubscriptions().subscribe((data: Array<any>) => {
      this.displayedSubs = data;
    });
  }

  contains(userSubs: any[], elem: any): boolean {
    for (let i = 0; i < userSubs.length; i++) {
      if (userSubs[i].name === elem.name) {
        return true;
      }
    }
    return false;
  }

  checkSolvency(subscription: any): boolean {
    return this.logUser.getBalance() <= subscription.cost;
  }

  subscribeClick(subscription) {
    this.http.subscribeUser(this.logUser.getUser(), subscription.idsubscription)
      .subscribe(user => {
        this.logUser.setUser(user);
      });
  }

  unsubscribeClick(subscription) {
    this.http.unsubscribeUser(this.logUser.getUser(), subscription.idsubscription)
      .subscribe(user => {
        this.logUser.setUser(user);
      });
  }
}

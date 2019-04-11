import {Component, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';
import {LoggedUser} from '../model/LoggedUser';
import {HttpService} from '../services/http.service';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  @ViewChild('addBalance') addBalance;
  modalRef: BsModalRef;

  constructor(private ModalService: BsModalService, private userInfo: UserIDService, private logUser: LoggedUser,
              private http: HttpService) { }

  showModal() {
    this.modalRef = this.ModalService.show(this.addBalance);
  }

  plusBalance($event): void {
    // this.logUser.setBalance((this.logUser.getBalance()) + +$event);
    // this.userInfo.balance = +this.userInfo.balance + +$event;
    this.http.addBalance(this.logUser.getId(), $event).subscribe(user => this.logUser.setUser(user));
  }

  updateBalance(): void {
    this.http.updateUser(this.logUser.getId()).subscribe(user => this.logUser.setUser(user));
    console.log(this.logUser.getUser());
  }

}

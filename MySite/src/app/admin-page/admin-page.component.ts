import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent {
  @ViewChild('addTemplate') addTemplate;
  @ViewChild('editTemplate') editTemplate;

  modalRef: BsModalRef;
  public users: any[];
  public subscriptions: any[];
  public viewController = true;
  public addSubscriptionName: string;
  public addSubscriptionCost: string;
  public currentEditSubscription: any;
  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getUsers()
      .subscribe(users => this.users = users);
    http.getSubscriptions()
      .subscribe(subscriptions => this.subscriptions = subscriptions);
  }
  addSubcription() {
    const newSubscription = {
      id: Date.now() + '',
      name: this.addSubscriptionName,
      cost: this.addSubscriptionCost,
      subscribers: 0
    };

    this.subscriptions.push(newSubscription);
    this.modalRef.hide();
  }
  showModal() {
    this.modalRef = this.modalService.show(this.addTemplate);
  }
  deleteSubscription(index: number) {
    const subscription = this.subscriptions[index];

    this.http.deleteSubscription(subscription.id)
      .subscribe(() => {
        this.subscriptions.splice(index, 1);
      });
  }
  editSubscription(userIndex: number) {
    this.currentEditSubscription = this.subscriptions[userIndex];

    this.modalRef = this.modalService.show(this.editTemplate);
  }
}

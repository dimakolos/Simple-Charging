import {NgModule} from '@angular/core';
import {RegisterComponent} from './register.component';
import {BrowserModule} from '@angular/platform-browser';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {BsDropdownModule, ButtonsModule, ModalModule} from 'ngx-bootstrap';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {TestComponent} from '../test/test.component';
import {UserModel} from '../model/UserModel';

@NgModule ({
  imports: [
    CommonModule,
    FormsModule,
    Ng4LoadingSpinnerModule.forRoot()
  ],
  exports: [
    RegisterComponent
  ],
  declarations: [
    RegisterComponent
  ],
  providers: [UserModel]
})

export class RegisterModule {
}

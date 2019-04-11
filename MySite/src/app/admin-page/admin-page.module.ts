import {NgModule} from '@angular/core';
import {BsDropdownModule, ButtonsModule, ModalModule} from 'ngx-bootstrap';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {AdminPageComponent} from './admin-page.component';

@NgModule ({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  declarations: [AdminPageComponent],
  exports: [AdminPageComponent]
})

export class AdminPageModule {
}

import {NgModule} from '@angular/core';
import {BsDropdownModule, ButtonsModule, ModalModule} from 'ngx-bootstrap';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {TestComponent} from './test.component';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot()
  ],
  exports: [
    TestComponent
  ],
  declarations: [
    TestComponent
  ],
  providers: []
})

export class TestModule {
}

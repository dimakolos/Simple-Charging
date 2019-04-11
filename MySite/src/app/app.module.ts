import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {IndexComponent} from './index/index.component';
import {NavbarComponent} from './navbar/navbar.component';
import {BalanceComponent} from './balance/balance.component';
import {SubscriptionsComponent} from './subscriptions/subscriptions.component';
import {SubscriptionsModule} from './subscriptions/subscriptions.module';
import {TestComponent} from './test/test.component';
import {HttpService} from './services/http.service';
import {AccountmenuModule} from './accountmenu/accountmenu.module';
import {AccountmenuComponent} from './accountmenu/accountmenu.component';
import {FilterPipeModule} from 'ngx-filter-pipe';
import { AdminPageComponent } from './admin-page/admin-page.component';
import {AdminPageModule} from './admin-page/admin-page.module';
import {FormsModule} from '@angular/forms';
import {UserIDService} from './services/http.IDservice';
import {TestModule} from './test/test.module';
import {RegisterModule} from './register/register.module';
import {HttpAuthUser} from './services/http.AuthUser';
import {LoggedUser} from './model/LoggedUser';

const appRoutes: Routes = [
  {path: '', component: AppComponent},
  {path: 'balance', component: BalanceComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'subscriptions', component: SubscriptionsComponent},
  {path: 'test', component: TestComponent},
  {path: 'accountmenu', component: AccountmenuComponent},
  {path: 'adminpage', component: AdminPageComponent}
  // {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    BalanceComponent,
    NavbarComponent
  ],
  imports: [
    // NavbarModule,
    FormsModule,
    AdminPageModule,
    HttpClientModule,
    SubscriptionsModule,
    AccountmenuModule,
    BrowserModule,
    FilterPipeModule,
    RouterModule.forRoot(appRoutes),
    TestModule,
    RegisterModule
  ],
  providers: [
    HttpService,
    UserIDService,
    HttpAuthUser,
    LoggedUser
  ],
  bootstrap: [AppComponent]
})


export class AppModule {
}

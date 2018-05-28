import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MortiersComponent } from './mortiers/mortiers.component';

import { LoginService } from './login.service';
import { MortierService } from './mortier.service';
import { UserService } from './user.service';
import { MortierComponent } from './mortier/mortier.component';
import { CreateMortierComponent } from './create-mortier/create-mortier.component';
import { SignupComponent } from './signup/signup.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { XhrInterceptor } from './http.interceptor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MortiersComponent,
    MortierComponent,
    CreateMortierComponent,
    SignupComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    routing
  ],
  providers: [
  LoginService,
  MortierService,
  UserService,
  { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  
  bootstrap: [AppComponent]
})
export class AppModule { }

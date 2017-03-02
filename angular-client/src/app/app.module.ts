import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ClarityModule } from "clarity-angular";
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { AppRoutingModule } from "./app-routing.module";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthGuard } from "./guards/auth.guard";
import { AuthenticationService } from "./services/authentication.service";
import { requestOptionsProvider } from "./services/default-request-options.service";
import {Credentials} from "./models/credentials";
import {Router} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    RegisterComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ClarityModule.forChild(),
    AppRoutingModule
  ],
  providers: [
    AuthGuard,
    AuthenticationService,
    requestOptionsProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private authenticationService:AuthenticationService, private router: Router) {
    authenticationService.authenticate(new Credentials()).subscribe(
      () => router.navigate(['/'])
    );
  }
}

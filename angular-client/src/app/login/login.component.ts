import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators, AbstractControl} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

import {AuthenticationService} from "../services/authentication.service";
import {Credentials} from "../models/credentials";
import {User} from "../models/user";

function credentialsValidator(c: AbstractControl) {
  return c.get('username') || c.get('password')
    ? null : {'nomatch': true};
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {

    this.authenticationService.logout();

    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    }, {validator: credentialsValidator});
  }

  login() {
    let credentials: Credentials =
      new Credentials(this.form.get('username').value, this.form.get('password').value);

    this.authenticationService.authenticate(credentials)
      .subscribe(
        data => {
          this.router.navigate(['/']);
        },
        error => {
        });
  }

}


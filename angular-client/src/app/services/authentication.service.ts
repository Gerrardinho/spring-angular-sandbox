import { Injectable } from '@angular/core';
import {Http, RequestOptions} from "@angular/http";

import {Credentials} from "../models/credentials";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

  constructor(
    private http: Http,
    private requestOptions: RequestOptions
  ) {}

  authenticate(credentials: Credentials) {

    if (credentials.valid()) {
      this.requestOptions.headers.set('Authorization', 'Basic ' + credentials.encrypt())
    }

    return this.http.get('/principal')
      .map(res => {
        let user = res.json();
        if (user) {
          localStorage.setItem('user', JSON.stringify(user));
        }
        return user;
    });
  }

  logout() {
    return this.http.post('/logout', '{}')
      .map(() => localStorage.removeItem('user'));
  }

}

import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {HttpClient, HttpParams} from '@angular/common/http';


@Injectable()
export class UserService {

  constructor (private http: Http, private httpClient: HttpClient) {}

  create(username: string, password: string) {
    let url = "/server/api/user/create";
    
    console.log('Appel du service de creation de user');
    return this.http.post(url, {username: username, password: password});
  }

  getUsers(){
  	let url = "/server/api/user/all";
    return this.http.get(url, { withCredentials: false });
  }

}
	
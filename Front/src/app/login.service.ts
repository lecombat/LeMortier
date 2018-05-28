import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class LoginService {

  constructor (private http: HttpClient) {}

  /*
  sendCredential(username: string, password: string) {
    let url = "/server/api/user/login";
    let headers = new Headers(
    {
      'Content-Type': 'application/x-www-form-urlencoded',
      'Access-Control-Allow-Credentials' : false
    });
    console.log('Appel du service connexion');
    console.log('User '+username);
    console.log('password '+password);
    return this.http.post(url, {username: username, password: password}, {headers: headers, withCredentials : false});
  }
  */


  authenticate(credentials) {

        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});

        return this.http.get('/server/api/user/authentificate', {headers: headers});

  }


  logout() {
     let url = "/server/logout";
     return this.http.get(url, { withCredentials: true });
   }

}

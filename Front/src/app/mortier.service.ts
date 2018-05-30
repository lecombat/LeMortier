import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

@Injectable()
export class MortierService {

  constructor(private http: Http) { }

  create(nom: string, ownerUserId: string, users:string) {
    let url = "/server/api/mortier/create";

    //console.log(users);
    
    console.log('Appel du service de creation du mortier');
    let body = {nom: nom, ownerUserId: ownerUserId, users: users};
    console.log(JSON.stringify(body));

    return this.http.post(url, body);
  }

  getMortiers(userId : string){
    let url = "/server/api/mortier/mortiersForUser/"+userId;
    return this.http.get(url, { withCredentials: false });
  }

}
	
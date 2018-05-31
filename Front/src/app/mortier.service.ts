import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

@Injectable()
export class MortierService {

  constructor(private http: Http) { }

  create(nom: string, ownerUserId: string, users:string) {
    let url = "/server/api/mortier/create";
    
    console.log('Appel du service de creation du mortier');
    let body = {nom: nom, ownerUserId: ownerUserId, users: users};

    return this.http.post(url, {nom: nom, ownerUserId: ownerUserId, users: users});
  }

/**
* Retourne les mortiers creer par le user passé en parametre
*
*/
  getMortiers(userId : string){
    let url = "/server/api/mortier/mortiersForUser/"+userId;
    return this.http.get(url, { withCredentials: false });
  }

  getMortier(mortierId : number){
    let url = "/server/api/mortier/"+mortierId;
    return this.http.get(url, { withCredentials: false });
  }

}
	
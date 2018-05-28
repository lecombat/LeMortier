import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

@Injectable()
export class MortierService {

  constructor(private http: Http) { }

  create(mortier) {
    let url = "/server/api/mortier/create";
    
    console.log('Appel du service de creation du mortier');
    return this.http.post(url, mortier);
  }

  getMortiers(userId : string){
    let url = "/server/api/mortier/mortiersForUser/"+userId;
    return this.http.get(url, { withCredentials: false });
  }

}
	
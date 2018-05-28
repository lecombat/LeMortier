import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	loggedIn: boolean = false;
	isSubmitted: boolean = false;
	username: string;
	password: string;

	constructor (private loginService: LoginService, private router: Router) {
	}

	login() {
		let credentials = {username: this.username, password: this.password};

	    this.loginService.authenticate(credentials).subscribe(
	    	data => {
	    		if (data['username']) {
                	this.loggedIn = true;

                	localStorage.setItem("username", data['name']);
	            	localStorage.setItem("userId", data['id']);
			        this.router.navigateByUrl('/mortiers');
            	}
	    	},
      		err => {
      			alert("Le user "+this.username+" et/ou password incorrect ");
      			this.loggedIn = false;
      		}

	    );
	    this.isSubmitted = true;
  	}


	ngOnInit() {
	}

}

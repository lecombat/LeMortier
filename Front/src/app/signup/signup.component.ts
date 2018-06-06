import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

	username: string;
	password: string;
	email: string;
	
	signup: boolean;

  constructor (private userService: UserService, private router: Router) {

  }


  onSubmit() {
	  	this.userService.create(this.username, this.password).subscribe(
	      res => {
	      	alert("Le compte "+this.username+" a bien été crée. Vous pouvez à present vous connecter");
	      	this.router.navigate(['/login']);
	      },

	      err => {
	      	alert("Erreur lors de la creation du user :"+this.username); //TODO erreur selon le statut code de la requete
	      	console.log(err);
	      	console.error('Erreur lors de la creation de compte'); //TODO gestion des differents type d'erreurs
	      }
	    );
	}


  ngOnInit() {
  }

}

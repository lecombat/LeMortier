import { Component, OnInit } from '@angular/core';
import { MortierService } from '../mortier.service';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Observable} from 'rxjs';
import { debounceTime, distinctUntilChanged, map} from 'rxjs/operators';
import { User } from '../domain/user';



@Component({
  selector: 'app-create-mortier',
  templateUrl: './create-mortier.component.html',
  styleUrls: ['./create-mortier.component.css']
})
export class CreateMortierComponent implements OnInit {
  
  nom: string;
  userId: string;

  private listParticipants: Array<User>;

  private listParticipantsMortier: Array<any> = [];

  private newParticipant: any = {};

  addFieldValue() {
    this.listParticipantsMortier.push(this.newParticipant);
    this.newParticipant = {};
  }

  deleteFieldValue(index) {
    this.listParticipantsMortier.splice(index, 1);
  }

  constructor(private mortierService: MortierService, private userService: UserService, private router: Router) { 
    this.userId = localStorage.getItem("userId");
    this.getUsers();
  }


  //formatMatches = (value: any) => value.username || '' ||JSON.stringify(value);
  formatMatches = (value: User) => value.username || '';

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),

      distinctUntilChanged(),

      map( (term: string) => term.length < 2 ? [] : this.listParticipants.filter(v => v.username.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    );

  onSubmit(){
  	this.mortierService.create({nom: this.nom, ownerUserId: this.userId, users: this.listParticipantsMortier}).subscribe(
	      res => {
          this.router.navigateByUrl('/mortiers');
	      },
	      err => console.log(err)
	    );
  }

/**
Appelle le service
**/
  getUsers(){
    this.userService.getUsers().subscribe(
      res => {
        this.listParticipants = <User[]>JSON.parse(JSON.parse(JSON.stringify(res))._body);
      },
      err => {
        console.log("Erreur lors de la recuperation des users");
      }

    );
  }

  ngOnInit() {
  }

}

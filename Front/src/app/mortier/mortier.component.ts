import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable} from 'rxjs';
import { debounceTime, distinctUntilChanged, map} from 'rxjs/operators';

import { MortierService } from '../mortier.service';
import { UserService } from '../user.service';
import { User } from '../domain/user';

@Component({
  selector: 'app-mortier',
  templateUrl: './mortier.component.html',
  styleUrls: ['./mortier.component.css']
})
export class MortierComponent implements OnInit {

  mortierId: number;
  mortier:any = {};
  private listParticipants: Array<User>;

  private depenseList: Array<any> = [];
  private newDepense: any = {};

  constructor(private route: ActivatedRoute, private mortierService: MortierService, private userService: UserService, private router: Router) {
    this.getUsers(); //TODO put this in the cache
		this.route.params.forEach((params: Params) => {
     		this.mortierId = params['mortierId'];
		});

    this.getMortier(this.mortierId);
  }

  getMortier(mortierId: number){
      this.mortierService.getMortier(mortierId).subscribe(
        res => {
            this.mortier = JSON.parse(JSON.parse(JSON.stringify(res))._body);
            console.log(this.mortier);
            console.log(this.mortier.depenses);
            if( this.mortier.depenses !== undefined){
              this.depenseList = this.mortier.depenses;
            }
          },
        err => {
          console.log("Erreur lors de la recherche du mortier");
        }

        );
  }
    
  addFieldValue() {
      this.depenseList.push(this.newDepense);
      this.newDepense = {};
  }

  deleteFieldValue(index) {
      this.depenseList.splice(index, 1);
  }

  //formatMatches = (value: any) => value.username || '' ||JSON.stringify(value);
  formatMatches = (value: User) => value.username || '';

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),

      distinctUntilChanged(),

      map( (term: string) => term.length < 2 ? [] : this.listParticipants.filter(v => v.username.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    );

  /**
  * Appelle le service de remonter des utilisateurs
  *
  */
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

  onSubmit(){
    this.mortierService.addDepenses(this.mortierId, this.depenseList).subscribe(
      res => {
        alert("Les depenses ont bien été rajouté et/ou Maj au mortier");
        this.router.navigateByUrl('/mortiers');
        },
        err =>{
          alert("Erreur lors de l'ajout de(s) depense(s)");
        }

      );
  }


  ngOnInit() {
  }

}
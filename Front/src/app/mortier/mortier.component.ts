import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Params } from '@angular/router';

import { MortierService } from '../mortier.service';

@Component({
  selector: 'app-mortier',
  templateUrl: './mortier.component.html',
  styleUrls: ['./mortier.component.css']
})
export class MortierComponent implements OnInit {

  mortierId: number;
  mortier:any = {};
  depenseList;

  constructor(private route: ActivatedRoute, private mortierService: MortierService) {
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
            this.depenseList = this.mortier.depenses;
          },
        err => {
          console.log("Erreur lors de la recherche du mortier");
        }

        );
  }

  ngOnInit() {
  }

}
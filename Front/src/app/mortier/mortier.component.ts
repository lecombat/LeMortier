import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-mortier',
  templateUrl: './mortier.component.html',
  styleUrls: ['./mortier.component.css']
})
export class MortierComponent implements OnInit {

  mortier: Object;

  constructor(private route: ActivatedRoute) {
		this.route.params.forEach((params: Params) => {
     		this.mortier = params['mortier'];
		});
  }

  ngOnInit() {
  }

}
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MortierService } from '../mortier.service';

@Component({
  selector: 'app-mortiers',
  templateUrl: './mortiers.component.html',
  styleUrls: ['./mortiers.component.css']
})
export class MortiersComponent implements OnInit {

mortierList: Object[];
userId: string;
	
constructor(private mortierService: MortierService, private router: Router) {
	this.userId = localStorage.getItem("userId");
	this.getMortiers(this.userId);
}

getMortiers(userId: string) {
	this.mortierService.getMortiers(userId).subscribe(
		res => {
    		this.mortierList = JSON.parse(JSON.parse(JSON.stringify(res))._body);
  		},
  		error => console.log(error)
	)
}

onSelectMortier(mortier: Object){
	this.router.navigate(['/mortier', mortier]);
}

ngOnInit() {
}

}

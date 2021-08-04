import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-memberdetails-output',
  templateUrl: './memberdetails-output.component.html',
  styleUrls: ['./memberdetails-output.component.css']
})
export class MemberdetailsOutputComponent implements OnInit {

  constructor(private _route : Router,private route : ActivatedRoute) { }
  res: any

  ngOnInit(): void {
    this.route.queryParams.subscribe(
     result =>{
     this.res = JSON.parse(result.data);
      console.log(JSON.parse(result.data));
     })
         
  }
  logout(){
    console.log("logout");
    sessionStorage.removeItem('key');
    sessionStorage.removeItem('token');
  }

}

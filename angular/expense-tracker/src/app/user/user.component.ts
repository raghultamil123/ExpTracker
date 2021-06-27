import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

    console.log("inside user compeo");
    if(localStorage.getItem("userId")){
      this.router.navigate(["./details"],{relativeTo:this.route})
    }

  }

}

import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails(){
    if(localStorage.getItem("userId")){
      this.userService.getUserDetails(localStorage.getItem("userId"))
      .subscribe( (res)=>{
        console.log(res);
      } )
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/shared/model/user.model';

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

  user:User = {
    userId:'',
    firstName: '',lastName: '',dateOfBirth: ''
  }

  getUserDetails(){
    if(localStorage.getItem("userId")){
      this.userService.getUserDetails(localStorage.getItem("userId"))
      .subscribe( (res)=>{
        console.log(res);
        this.user = res
      } )
    }
  }

}

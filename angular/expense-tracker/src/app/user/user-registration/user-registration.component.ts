import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/model/user.model';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {

  constructor() { }

  user:User={
    'userId':'',dateOfBirth:'',firstName:'',lastName:'',userEmail:[
      {
        id:'',email:'',isPrimary:false
      }
    ],mobile:[
      {
        id:'',phone:'',isAllowedToRead:false
      }
    ]
  }

  addEmail(){
    this.user.userEmail.push(
      {
        id:'',email:'',isPrimary:false
      }
    )
  }
  addMobile(){
    this.user.mobile.push({
      id:'',phone:'',isAllowedToRead:false
    })
  }

  ngOnInit(): void {
  }

  deleteEmail(email,index){
     this.user.userEmail.splice(index,1)
  }
  deletePhone(phone,index){
    this.user.mobile.splice(index,1)
  }

}

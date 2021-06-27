import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
  }
 
  authenticateUser(username:string,password:string){
     this.userService.authenticateUser(username,password)
     .subscribe( (res)=>{
       this.router.navigateByUrl('/main');
       localStorage.setItem("userId",res.userId);

     } )
  }


}

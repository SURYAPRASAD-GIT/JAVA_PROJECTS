import { Router } from '@angular/router';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';
import { Userdetailspayload } from '../userdetailspayload';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user: Userdetailspayload=new Userdetailspayload();

  constructor(private userService: UsersService, private router: Router) { }

  ngOnInit(): void {
  }

  saveUser(){
    this.userService.registerUser(this.user).subscribe(data =>{
      console.log(data);
      this.goToUserList();
    },
    error => console.log(error));
   }  
goToUserList(){
  this.router.navigate(['/users'])
}

onSubmit(){
    console.log(this.user);
  
    this.saveUser();

  }

}

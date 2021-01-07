import { Router } from '@angular/router';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';
import {Userdetailspayload} from '../userdetailspayload';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users?: Userdetailspayload[];
  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(){
    this.usersService.getUsersList().subscribe(data=>{
     this.users=data;
    });
  }

  updateUser(id: number){
    this.router.navigate(['update-user', id])
  }

  deleteUser(id: number){
    this.usersService.deleteUser(id).subscribe(data => {
      console.log(data);
      this.getUsers();
    })
  }

  viewUserDetails(id:number){
    this.router.navigate(['user_details', id]);
  }


}

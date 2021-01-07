import { ActivatedRoute, Router } from '@angular/router';
import { Userdetailspayload } from './../userdetailspayload';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id!: number;

  user: Userdetailspayload=new Userdetailspayload();
   
  constructor( private userService: UsersService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.userService.getUserById(this.id).subscribe(data =>{
      this.user=data;
    },
    error => console.log(error));
  }

   onSubmit(){
     this.userService.updateUser(this.id, this.user).subscribe( data => {
          this.goToEmployeeList();
     },
     error => console.log(error));
   }

   goToEmployeeList(){
     this.router.navigate(['/users'])
   }

}

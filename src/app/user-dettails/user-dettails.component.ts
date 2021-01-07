import { UsersService } from './../users.service';
import { ActivatedRoute } from '@angular/router';
import { Userdetailspayload } from './../userdetailspayload';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-dettails',
  templateUrl: './user-dettails.component.html',
  styleUrls: ['./user-dettails.component.css']
})
export class UserDettailsComponent implements OnInit {

   id!:number;
   user!:Userdetailspayload;

  constructor(private route: ActivatedRoute, private usersService:UsersService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.user=new Userdetailspayload();
    
    this.usersService.getUserById(this.id).subscribe(data => {
      this.user=data;
    })

  }

}

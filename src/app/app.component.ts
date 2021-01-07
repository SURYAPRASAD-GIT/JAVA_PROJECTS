import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'USER_MANAGEMENT_SYSTEM';
  
public today!: number;
constructor() { 
 
  setInterval(() => {
    this.today = Date.now();
  }, 1);
}



}

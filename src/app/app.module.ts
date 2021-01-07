
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { HttpClientModule }  from '@angular/common/http';
import { RegisterUserComponent } from './register-user/register-user.component';
import { FormsModule}  from '@angular/forms';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDettailsComponent } from './user-dettails/user-dettails.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    RegisterUserComponent,
    UpdateUserComponent,
    UserDettailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

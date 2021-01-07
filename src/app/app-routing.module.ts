import { UserDettailsComponent } from './user-dettails/user-dettails.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserListComponent } from './user-list/user-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'register_user', component: RegisterUserComponent},
  {path: 'update-user/:id', component: UpdateUserComponent},
  {path:'', redirectTo: 'users', pathMatch: 'full'},
  {path:'user_details/:id',component:UserDettailsComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

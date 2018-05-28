import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { MortierComponent } from './mortier/mortier.component';
import { MortiersComponent } from './mortiers/mortiers.component';
import { CreateMortierComponent } from './create-mortier/create-mortier.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
  	path: 'login',
  	component: LoginComponent
  },
  {
    path: 'userCreate',
    component: SignupComponent
  },
  {
  	path: 'mortier',
  	component: MortierComponent
  },
  {
    path: 'mortiers',
    component: MortiersComponent
  },
  {
    path: 'mortier/create',
    component: CreateMortierComponent
  },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
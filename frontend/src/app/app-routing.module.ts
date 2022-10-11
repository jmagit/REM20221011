import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactosAddComponent, ContactosEditComponent, ContactosListComponent, ContactosViewComponent } from './contactos';
import { AuthGuard, InRoleGuard, RegisterUserComponent } from './security';
import { HomeComponent, PageNotFoundComponent } from './main';

const routes: Routes = [
  { path: '', pathMatch: 'full', component: HomeComponent },
  { path: 'inicio', component: HomeComponent },
  // { path: 'demos', component: DemosComponent, data: { pageTitle: 'Demos' } },
  { path: 'contactos', component: ContactosListComponent, data: { pageTitle: 'Contactos' } },
  { path: 'contactos/add', component: ContactosAddComponent, canActivate: [AuthGuard] },
  { path: 'contactos/:id/edit', component: ContactosEditComponent, canActivate: [AuthGuard] },
  { path: 'contactos/:id', component: ContactosViewComponent },
  { path: 'contactos/:id/:kk', component: ContactosViewComponent },
  { path: 'alisha/passion', redirectTo: '/contactos/9' },
  {
    path: 'blog', children: [
      { path: '', component: ContactosListComponent },
      { path: 'add', component: ContactosAddComponent },
      { path: ':id/edit', component: ContactosEditComponent },
      { path: ':id', component: ContactosViewComponent },
      { path: ':id/:kk', component: ContactosViewComponent },
    ]
  },
  {
    path: 'config', loadChildren: () => import('./config/config.module').then(mod => mod.ConfigModule),
    canLoad: [InRoleGuard], data: { roles: ['Administradores', 'ADMIN'] }
  },
  { path: 'registro', component: RegisterUserComponent },

  // { path: 'blog', loadChildren: () => import('./blog').then(mod => mod.BlogModule)},
  { path: '404.html', component: PageNotFoundComponent },
  { path: '**', component: PageNotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

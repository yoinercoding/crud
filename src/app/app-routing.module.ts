import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './components/toList/listar.component';
import { AgregarComponent } from './components/add/agregar.component';
import { EditarComponent } from './components/edit/editar.component';

const routes: Routes = [
  {path:'listar', component:ListarComponent},
  {path:'agregar', component:AgregarComponent},
  {path:'editar', component:EditarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

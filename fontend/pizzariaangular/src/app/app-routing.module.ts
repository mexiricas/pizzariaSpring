import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { PizzaComponent } from './pizza/pizza.component';
import { IngredienteComponent } from './ingrediente/ingrediente.component';


const routes: Routes = [
  { path: 'home', component: AppComponent },
  { path: 'ingrediente', component: IngredienteComponent },
  { path: 'pizza', component: PizzaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

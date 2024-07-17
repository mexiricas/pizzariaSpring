import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


import { PizzaComponent } from './pizza.component';

@NgModule({
  declarations: [
    PizzaComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    PizzaComponent
  ]
})
export class PizzaModule { }

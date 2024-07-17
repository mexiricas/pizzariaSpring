import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IngredienteService } from './ingrediente/ingrediente.service';
import { PizzaModule } from './pizza/pizza.module';
import { IngredienteComponent } from './ingrediente/ingrediente.component';


@NgModule({
  declarations: [
    AppComponent,
    IngredienteComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    PizzaModule
  ],
  providers: [IngredienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }

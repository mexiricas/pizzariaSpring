import { EnumPizza } from './PizzaEnum';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';


import { IngredienteService } from './../ingrediente/ingrediente.service';
import { PizzaService } from './pizza.service';
import { Ingrediente } from './../ingrediente/Ingrediente';
import { Pizza } from './pizza';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {
  public pizzas: Pizza[];
  public pizza: Pizza;
  public ingredientes: Ingrediente[];
  public enumPizza: EnumPizza[];
  public qtd: String;

  constructor(private pizzaService: PizzaService) { }

  ngOnInit(): void {
    this.getListagemPizzas();
    this.getListagemEnumPizzas();
    // this.getQtd();
  }

  public getQtd(): void {
    this.pizzaService.getQtd().subscribe(
      (response: String) => {
        this.qtd = response;
        console.log(this.qtd);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public getListagemPizzas(): void {
    this.pizzaService.getListaPizzas().subscribe(
      (response: Pizza[]) => {
        this.pizzas = response;
        console.log(this.pizzas);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getListagemIngrediente(): void {
    this.pizzaService.getListaIngrediente().subscribe(
      (response: Ingrediente[]) => {
        this.ingredientes = response;
        console.log(this.ingredientes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getListagemEnumPizzas(): void {
    this.pizzaService.getListaPizzasEnum().subscribe(
      (response: EnumPizza[]) => {
        this.enumPizza = response;
        console.log(this.enumPizza);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onAddPizza(addFormPizza: NgForm): void {
    document.getElementById('add-pizza-form').click();
    this.pizzaService.addPizza(addFormPizza.value).subscribe(
      (response: Pizza) => {
        console.log(response);
        this.getListagemPizzas();
        addFormPizza.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addFormPizza.reset();
      }
    );
  }

  public onUpdatePizza(iupdate: Pizza): void {
    var value = iupdate.preco.toLocaleString('pt-BR', { minimumFractionDigits: 2 });
    // iupdate.preco = parseInt(value.replace(/[^0-9,]*/g, '').replace(',', '.'));
    this.pizzaService.updatePizza(iupdate).subscribe(
      (response: Pizza) => {
        console.log(response);
        this.getListagemPizzas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePizza(pizzaId: any): void {
    let id = parseInt(pizzaId)
    this.pizzaService.deletePizza(pizzaId).subscribe(
      (response: void) => {
        console.log(response);
        this.getListagemPizzas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onOpenModal(i: Pizza | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      this.getListagemIngrediente();
      button.setAttribute('data-target', '#addPizzaModal');
    }
    if (mode === 'edit') {
      if (i !== null) { this.pizza = i; }
      this.getListagemIngrediente();
      button.setAttribute('data-target', '#updatePizzaModal');
    }
    if (mode === 'delete') {
      if (i !== null) { this.pizza = i; }

      button.setAttribute('data-target', '#deletePizzaModal');
    }

    if (container !== null) { container.appendChild(button); }
    button.click();
  }
}

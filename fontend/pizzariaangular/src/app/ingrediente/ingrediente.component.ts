import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';


import { IngredienteService } from './ingrediente.service';
import { EnumIngrediente } from './enumIngrediente';
import { Ingrediente } from './Ingrediente';


@Component({
  selector: 'app-ingrediente',
  templateUrl: './ingrediente.component.html',
  styleUrls: ['./ingrediente.component.css']
})
export class IngredienteComponent implements OnInit {
  public ingredientes: Ingrediente[];
  public ingrediente: Ingrediente;
  public ingredienteDelete: Ingrediente;
  public enumIngrediente: EnumIngrediente[];

  constructor(private ingredienteservice: IngredienteService) { }

  ngOnInit(): void {
    this.getListagemIngrediente();
    this.getListagemEnumIngrediente();
  }

  public getListagemIngrediente(): void {
    this.ingredienteservice.getListaIngrediente().subscribe(
      (response: Ingrediente[]) => {
        this.ingredientes = response;
        console.log(this.ingredientes);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getListagemEnumIngrediente(): void {
    this.ingredienteservice.getEnumIngrediente().subscribe(
      (response: EnumIngrediente[]) => {
        this.enumIngrediente = response;
        console.log(this.enumIngrediente);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddIngrediente(addForm: NgForm): void {
    // document.getElementById('add-ingrediente-form').
    document.getElementById('add-ingrediente-form').click();
    this.ingredienteservice.addIngrediente(addForm.value).subscribe(
      (response: Ingrediente) => {
        console.log(response);
        this.getListagemIngrediente();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateIngrediente(iupdate: Ingrediente): void {
    this.ingredienteservice.updateIngrediente(iupdate).subscribe(
      (response: Ingrediente) => {
        console.log(response);
        this.getListagemIngrediente();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onDeleteIngrediente(ingredienteId: any): void {
    let id = parseInt(ingredienteId)
    this.ingredienteservice.deleteIngrediente(ingredienteId).subscribe(
      (response: void) => {
        console.log(response);
        this.getListagemIngrediente();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(i: Ingrediente | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addIngredienteModal');
    }
    if (mode === 'edit') {
      this.getListagemEnumIngrediente();
      if (i !== null) { this.ingrediente = i; }

      button.setAttribute('data-target', '#updateIngredienteModal');
    }
    if (mode === 'delete') {
      if (i !== null) { this.ingredienteDelete = i; }

      button.setAttribute('data-target', '#deleteIngredienteModal');
    }

    if (container !== null) { container.appendChild(button); }
    button.click();
  }

}

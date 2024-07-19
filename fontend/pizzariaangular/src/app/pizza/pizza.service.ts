import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from 'src/environments/environment';
import { Ingrediente } from './../ingrediente/Ingrediente';
import { Pizza } from './pizza';
import { EnumPizza } from './PizzaEnum';


@Injectable({
  providedIn: 'root'
})
export class PizzaService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getListaPizzas(): Observable<Pizza[]> {
    return this.http.get<Pizza[]>(`${this.apiServerUrl}/pizzas`);
  }

  public getListaIngrediente(): Observable<Ingrediente[]> {
    return this.http.get<Ingrediente[]>(`${this.apiServerUrl}/ingredientes`);
  }

  public getQtd(): Observable<String> {
    return this.http.get(`${this.apiServerUrl}/pizzas/quantaspizzas`,{responseType: 'text'});
  }

  public addPizza(pizza: Pizza): Observable<Pizza> {
    return this.http.post<Pizza>(`${this.apiServerUrl}/pizzas`, pizza);
  }

  public getListaPizzasEnum(): Observable<EnumPizza[]> {
    return this.http.get<EnumPizza[]>(`${this.apiServerUrl}/pizzas/enum`);
  }

  public updatePizza(pizza: Pizza): Observable<Pizza> {
    return this.http.put<Pizza>(`${this.apiServerUrl}/pizzas`, pizza);
  }

  public deletePizza(pizzaId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/pizzas/${pizzaId}`);
  }

}

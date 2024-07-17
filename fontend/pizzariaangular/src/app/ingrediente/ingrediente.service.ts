import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Ingrediente } from './Ingrediente';
import { EnumIngrediente } from './enumIngrediente';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IngredienteService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getListaIngrediente(): Observable<Ingrediente[]> {
    return this.http.get<Ingrediente[]>(`${this.apiServerUrl}/ingredientes`);
  }

  public getEnumIngrediente(): Observable<EnumIngrediente[]> {
    return this.http.get<EnumIngrediente[]>(`${this.apiServerUrl}/ingredientes/enum`);
  }

  public addIngrediente(ingrediente: Ingrediente): Observable<Ingrediente> {
    return this.http.post<Ingrediente>(`${this.apiServerUrl}/ingredientes`, ingrediente);
  }

  public updateIngrediente(ingrediente: Ingrediente): Observable<Ingrediente> {
    return this.http.put<Ingrediente>(`${this.apiServerUrl}/ingredientes/replace`, ingrediente);
  }

  public deleteIngrediente(ingredienteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/ingredientes/${ingredienteId}`);
  }
}

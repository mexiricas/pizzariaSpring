import { Ingrediente } from './../ingrediente/Ingrediente';

export interface Pizza {
    id: number;
    nome: string;
    preco: number;
    categoria: string;
    ingredientes: Ingrediente[];
}
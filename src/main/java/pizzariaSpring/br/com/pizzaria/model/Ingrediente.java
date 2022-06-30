package pizzariaSpring.br.com.pizzaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pizzariaSpring.br.com.pizzaria.EnumPizza.IngredienteCategoria;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private IngredienteCategoria categoria;
}

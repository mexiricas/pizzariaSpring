package pizzariaSpring.br.com.pizzaria.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pizzariaSpring.br.com.pizzaria.EnumPizza.PizzaCategoria;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private PizzaCategoria categoria;

    @ManyToMany
    private List<Ingrediente> ingredientes;

}

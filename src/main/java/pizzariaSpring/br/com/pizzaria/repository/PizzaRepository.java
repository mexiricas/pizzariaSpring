package pizzariaSpring.br.com.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzariaSpring.br.com.pizzaria.EnumPizza.PizzaCategoria;
import pizzariaSpring.br.com.pizzaria.model.Pizza;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
     List<Pizza> findByCategoria(PizzaCategoria categoria);
}

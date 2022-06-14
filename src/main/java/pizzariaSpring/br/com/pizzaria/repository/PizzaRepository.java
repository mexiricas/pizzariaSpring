package pizzariaSpring.br.com.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzariaSpring.br.com.pizzaria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

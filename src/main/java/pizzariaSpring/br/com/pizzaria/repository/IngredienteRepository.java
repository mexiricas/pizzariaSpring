package pizzariaSpring.br.com.pizzaria.repository;

import org.springframework.data.repository.CrudRepository;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
}

package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.repository.IngredienteRepository;
import pizzariaSpring.br.com.pizzaria.repository.PizzaRepository;
import pizzariaSpring.br.com.pizzaria.service.IngredienteService;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteControler {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public Iterable<Ingrediente> findAll(){
        return  ingredienteService.findAll();
    }


    @PostMapping
    public Ingrediente salvar(@RequestBody Ingrediente ingrediente ){
        return ingredienteService.salvar(ingrediente);
    }
}

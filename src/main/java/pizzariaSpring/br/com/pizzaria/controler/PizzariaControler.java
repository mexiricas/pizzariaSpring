package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.propertyeditor.IngredientePropertyEditor;
import pizzariaSpring.br.com.pizzaria.service.PizzaService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pizzas")
public class PizzariaControler {

    @Autowired private PizzaService pizzaService;

    @GetMapping
    public List<Pizza>  findAll(){
        return  pizzaService.findAll();
    }
    @GetMapping("/quantasbroto")
    public String quantasPizzasPorCategoria(@RequestParam @Valid String categoria){
        return "Atualmente temos " + pizzaService.findByCategoria(categoria).size() + " pizzas " +categoria+ " pedidas";
    }
    @GetMapping(path = "/enum")
    public List<String>enumAll(){
        List<String> enumLista = Arrays.stream(pizzaService.enumAll())
                .map(Enum::name)
                .collect(Collectors.toList());
        return  enumLista;
    }
    @GetMapping("quantaspizzas")
    public String quantasPizzas(){
        return "Atualmente temos " + pizzaService.count() + " pedidas";
    }

    @PostMapping
    public Pizza salvar(@RequestBody Pizza p){return pizzaService.salvar(p); }

    @PutMapping
    public Pizza replacePizza(@RequestBody Pizza p){return pizzaService.replace(p); }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
        pizzaService.deletarPizza(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

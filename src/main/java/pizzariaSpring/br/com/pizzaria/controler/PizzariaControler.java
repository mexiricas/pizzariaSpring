package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.service.PizzaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzariaControler {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza>  findAll(){
        return  pizzaService.findAll();
    }

    @GetMapping("/quantasbroto")
    public String quantasPizzasBroto(@RequestParam @Valid String categoria){
        return "Atualmente temos " + pizzaService.findByCategoria(categoria).size() + " pizzas " +categoria+ " pedidas";
    }

    @GetMapping("/quantasmedia/{categoria}")
    public String quantasPizzasMedia(){
        return "Atualmente temos " + pizzaService.count() + " pedidas";
    }
    @PostMapping
    public Pizza salvar(@RequestBody Pizza p){
       return pizzaService.salvar(p);
    }


}

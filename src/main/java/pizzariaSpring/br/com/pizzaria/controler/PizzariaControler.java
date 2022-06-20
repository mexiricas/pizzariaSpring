package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.service.PizzaService;

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

    @GetMapping("/quantas")
    public String quantasPizzas(){
        return "Atualmente temos " + pizzaService.count() + " pedidas";
    }

    @PostMapping
    public Pizza salvar(@RequestBody Pizza p){
       return pizzaService.salvar(p);
    }


}

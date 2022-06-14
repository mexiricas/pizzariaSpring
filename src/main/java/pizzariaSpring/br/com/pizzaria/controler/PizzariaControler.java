package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizzariaSpring.br.com.pizzaria.repository.PizzaRepository;

@RestController
@RequestMapping("pizzas")
public class PizzariaControler {

    @Autowired
    private  PizzaRepository pizzaRepository;


    @GetMapping("/quantas")
    public String quantasPizzas(){
        return "Atualmente temos " + pizzaRepository.count() + " pedidas";
    }




}

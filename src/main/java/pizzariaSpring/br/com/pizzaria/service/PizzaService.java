package pizzariaSpring.br.com.pizzaria.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzariaSpring.br.com.pizzaria.EnumPizza.PizzaCategoria;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.repository.PizzaRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
@Service
@RequiredArgsConstructor
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll(){
        return  pizzaRepository.findAll();
    }

    public List<Pizza> findByCategoria(String categoria){
        PizzaCategoria pizzaCategoria =  PizzaCategoria.valueOf(categoria);
        pizzaCategoria.getDesc();
        if(isNull(pizzaCategoria)) {
            return pizzaRepository.findByCategoria(pizzaCategoria);
        }
        return  new ArrayList<Pizza>();
    }

    public Pizza salvar(Pizza p){
        return pizzaRepository.save(p);
    }

    public Long count(){
        return pizzaRepository.count();
    }
}

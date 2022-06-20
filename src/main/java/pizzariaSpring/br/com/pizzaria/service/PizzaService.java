package pizzariaSpring.br.com.pizzaria.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzariaSpring.br.com.pizzaria.model.Pizza;
import pizzariaSpring.br.com.pizzaria.repository.PizzaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll(){
        return  pizzaRepository.findAll();
    }

    public Pizza salvar(Pizza p){
        return pizzaRepository.save(p);
    }

    public Long count(){
        return pizzaRepository.count();
    }
}

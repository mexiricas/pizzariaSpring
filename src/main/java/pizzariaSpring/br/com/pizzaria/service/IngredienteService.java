package pizzariaSpring.br.com.pizzaria.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.repository.IngredienteRepository;

@Service
@RequiredArgsConstructor
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;


    public Iterable<Ingrediente> findAll(){
        return  ingredienteRepository.findAll();
    }

    public Ingrediente salvar(Ingrediente ingrediente ){
        return ingredienteRepository.save(ingrediente);
    }


}

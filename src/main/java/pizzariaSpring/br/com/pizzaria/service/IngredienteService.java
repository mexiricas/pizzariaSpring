package pizzariaSpring.br.com.pizzaria.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pizzariaSpring.br.com.pizzaria.EnumPizza.IngredienteCategoria;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.repository.IngredienteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;


    public Iterable<Ingrediente> findAll(){
        return  ingredienteRepository.findAll();
    }
    
    public  Ingrediente findById(Long id){
        return ingredienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
    }

    public Ingrediente salvar(Ingrediente ingrediente ){
        return ingredienteRepository.save(ingrediente);
    }
    
    public void deletarIngrediente(Long id){
        Ingrediente ingrediente = findById(id);
        ingredienteRepository.deleteById(ingrediente.getId());
    }

    public void update(Ingrediente ingrediente) {
        Ingrediente i = findById(ingrediente.getId());
        ingrediente.setId(i.getId());
        ingredienteRepository.save(ingrediente);

    }

    public IngredienteCategoria[] enumAll() {
        return IngredienteCategoria.values() ;
    }
}

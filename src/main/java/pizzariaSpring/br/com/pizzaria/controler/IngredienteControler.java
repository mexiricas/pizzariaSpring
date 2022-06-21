package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.service.IngredienteService;

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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
        ingredienteService.deletarIngrediente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

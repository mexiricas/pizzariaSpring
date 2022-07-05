package pizzariaSpring.br.com.pizzaria.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzariaSpring.br.com.pizzaria.EnumPizza.IngredienteCategoria;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.service.IngredienteService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteControler {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public Iterable<Ingrediente> findAll(){
        return  ingredienteService.findAll();
    }
    @GetMapping(path = "/enum")
    public List<String>enumAll(){
        List<String> enumLista = Arrays.stream(ingredienteService.enumAll())
                .map(Enum::name)
                .collect(Collectors.toList());

        return  enumLista;
    }

    @PostMapping
    public Ingrediente salvar(@RequestBody Ingrediente ingrediente ){
        return ingredienteService.salvar(ingrediente);
    }

    @PutMapping(path = "/replace")
    public ResponseEntity< Void>  replace(@RequestBody Ingrediente ingrediente ){
        ingredienteService.update(ingrediente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
        ingredienteService.deletarIngrediente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

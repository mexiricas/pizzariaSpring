package pizzariaSpring.br.com.pizzaria.propertyeditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pizzariaSpring.br.com.pizzaria.model.Ingrediente;
import pizzariaSpring.br.com.pizzaria.repository.IngredienteRepository;

import java.beans.PropertyEditorSupport;

@Component
public class IngredientePropertyEditor extends PropertyEditorSupport {
    @Autowired private IngredienteRepository ingredienteRepository;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long idIngrediente = Long.parseLong(text);
        var ingrediente = ingredienteRepository.findById(idIngrediente);
        setValue(ingrediente);
    }
}

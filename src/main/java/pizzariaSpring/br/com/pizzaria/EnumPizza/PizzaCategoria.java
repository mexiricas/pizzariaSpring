package pizzariaSpring.br.com.pizzaria.EnumPizza;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
public enum PizzaCategoria {

    BROTINHO(1L,"broto"), MEDIA(2L,"media"), GRANDE(3L,"grande");

    private String desc;
    private Long id;

    PizzaCategoria( Long id, String desc) {
        this.desc = desc;
        this.id = id;
    }
}

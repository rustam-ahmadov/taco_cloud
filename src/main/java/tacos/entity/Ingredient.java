package tacos.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Ingredient implements Serializable {
    @Serial
    private static final long serialVersionUID = 2804362569139638980L;
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES , CHEESE , SAUCE
    }
}

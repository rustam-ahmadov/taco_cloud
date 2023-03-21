package tacos.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;

@Data
@Table
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Persistable<String> {
    @Id
    private final String id;
    private final String name;
    private final Type type;
    @PersistenceConstructor
    public Ingredient(String id, String name,Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    @Override
    public boolean isNew() {
        return id == null;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}

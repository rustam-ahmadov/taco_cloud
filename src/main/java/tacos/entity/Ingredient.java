package tacos.entity;


import jakarta.persistence.*;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    /* mappedBy is an attribute in the @ManyToMany annotation in Java's JPA (Java Persistence API)
        which is used to indicate the field in the target entity(Taco.class , field - ingredients) that owns the relationship.
        Taco.class owns the relationship*/
    @ManyToMany(mappedBy = "ingredients")
    List<Taco> tacos;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}

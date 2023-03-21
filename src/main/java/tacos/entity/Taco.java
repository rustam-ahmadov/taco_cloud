package tacos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    @JoinTable(
            name = "tacos_ingredients",
            joinColumns = @JoinColumn(name = "taco_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

    /*If you don't specify the @JoinColumn annotation on the owning side of a many-to-one relationship, Hibernate will generate a default foreign key column name based on the name of the referencing entity's table name and the referenced entity's primary key column name.
        For example, if you have a Car entity with a many-to-one relationship to a Person entity, and you don't specify the @JoinColumn annotation, Hibernate will generate a default foreign key column named person_id in the car table, which references the primary key column of the person table.
        However, it's generally a good practice to explicitly specify the @JoinColumn annotation to make the relationship more clear and to avoid any potential issues that may arise from using default naming conventions.*/
    @ManyToOne
    @JoinColumn(name = "taco_order_id")
    private TacoOrder tacoOrder;
}

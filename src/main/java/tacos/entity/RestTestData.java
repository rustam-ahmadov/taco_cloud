package tacos.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class RestTestData {
    private final String name;
    private Boolean isMale;
    private final double amount;
    public RestTestData(String name, Boolean isMale, Double amount) {
        this.name = name;
        this.isMale = isMale;
        this.amount = amount;
    }
}

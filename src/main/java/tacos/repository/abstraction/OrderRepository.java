package tacos.repository.abstraction;


import tacos.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}

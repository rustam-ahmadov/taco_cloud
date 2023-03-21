package tacos.repository;


import org.springframework.data.repository.CrudRepository;
import tacos.entity.TacoOrder;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    Optional<List<TacoOrder>> findTacoOrderByDeliveryZip(String deliveryZip);
}

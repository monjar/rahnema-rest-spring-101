package ind.amirali.Repository;

import ind.amirali.model.DeliveryGuy;
import ind.amirali.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface GuysRepository extends CrudRepository<DeliveryGuy, String> {

}

package Dao.ApiBaseData;

import Modal.AssortmentCoffe;
import Modal.OrderCoffe;

import java.util.List;

/**
 * Created by Evgeny on 08.09.2017.
 */
public interface CoffeTypeRepository extends CrudRepository<AssortmentCoffe> {
    List<AssortmentCoffe> getListTalbe(List<OrderCoffe> orderCoffesList);
}

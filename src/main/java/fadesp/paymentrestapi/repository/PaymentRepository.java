package fadesp.paymentrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.events.Event;

public interface PaymentRepository extends CrudRepository<Event, String> {
}

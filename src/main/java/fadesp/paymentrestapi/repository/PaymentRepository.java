package fadesp.paymentrestapi.repository;

import fadesp.paymentrestapi.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, String> {
}

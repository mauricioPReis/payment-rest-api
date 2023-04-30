package fadesp.paymentrestapi.repository;

import fadesp.paymentrestapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByName(String payerType);

    List<Payment> findByStats(String paymentStatus);
}

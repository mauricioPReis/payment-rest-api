package fadesp.paymentrestapi.repository;

import fadesp.paymentrestapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByPayerType(String payerType);

    List<Payment> findByPaymentStatus(String paymentStatus);
}

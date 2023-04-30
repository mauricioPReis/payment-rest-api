package fadesp.paymentrestapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import fadesp.paymentrestapi.model.Payment;
import fadesp.paymentrestapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> savePayment(List<Payment> payments){
        return repository.saveAll(payments);
    }

    public List<Payment> getPayments(){
        return repository.findAll();
    }

    public Optional<Payment> getPaymentById(Integer debitCode){
        return repository.findById(debitCode);
    }

    public List<Payment> getPaymentByPayerType(String payerType){
        return repository.findByPayerType(payerType);
    }

    public List<Payment> getPaymentByPaymentStatus(String paymentStatus){
        return repository.findByPaymentStatus(paymentStatus);
    }

    public Payment updatePayment(Payment payment){
        Payment updatedDo = new Payment();

        updatedDo = repository.getReferenceById(payment.getDebitCode());
        updatedDo.setPaymentStatus(payment.getPaymentStatus());

        return repository.save(updatedDo);
    }

    public void deletePayment(Integer debitCode, String paymentStatus){
        if (Objects.equals(paymentStatus, "pendente_processamento")){
            repository.deleteById(debitCode);
        }
    }
}

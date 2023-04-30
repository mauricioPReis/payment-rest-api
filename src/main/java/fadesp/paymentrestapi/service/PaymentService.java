package fadesp.paymentrestapi.service;

import java.util.List;
import java.util.Optional;

import fadesp.paymentrestapi.model.Payment;
import fadesp.paymentrestapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    /* Adicionar novc pagamento */
    public List<Payment> savePayment(List<Payment> payments){
        return repository.saveAll(payments);
    }

    /* Buscar todos os registo */
    public List<Payment> getPayments(){
        return repository.findAll();
    }

    /* Buscar pelo Id = debitCode */
    public Optional<Payment> getPaymentById(Integer debitCode){
        return repository.findById(debitCode);
    }

    /* Buscar pelo CPF/CNPJ = payerType */
    public List<Payment> getPaymentByPayerType(String payerType){
        return repository.findByName(payerType);
    }

    /* Buscar pelo  Status do pagamento = paymentStatus */
    public List<Payment> getPaymentByPaymentStatus(String paymentStatus){
        return repository.findByStats(paymentStatus);
    }

    public Payment updatePayment(Payment payment){
        Payment updatedDo = new Payment();

        updatedDo = repository.getReferenceById(payment.getDebitCode());
        updatedDo.setPaymentStatus(payment.getPaymentStatus());

        return repository.save(updatedDo);
    }

    public void deletePayment(Integer debitCode, String paymentStatus){
        if (paymentStatus == "pendente_processamento"){
            repository.deleteById(debitCode);
        }
    }
}

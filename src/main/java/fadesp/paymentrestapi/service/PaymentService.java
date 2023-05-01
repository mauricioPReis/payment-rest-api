package fadesp.paymentrestapi.service;

import java.util.Arrays;
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

    public Payment updatePayment(int debitCode, String paymentStatus) {
        Payment payment = repository.findByDebitCode(debitCode);

        if (payment == null) {
            throw new RuntimeException("Pagamento não encontrado");
        }

        if (payment.getPaymentStatus().equals("processado_sucesso")) {
            throw new RuntimeException("Não é possível alterar o status de um pagamento processado com sucesso");
        }

        if (payment.getPaymentStatus().equals("processado_falha") && !paymentStatus.equals("pendente_processamento")) {
            throw new RuntimeException("O status de um pagamento processado com falha só pode ser alterado para pendente_processamento");
        }

        List<String> allowedStatus = Arrays.asList("pendente_processamento", "processado_falha", "processado_sucesso");
        if (!allowedStatus.contains(paymentStatus)) {
            throw new RuntimeException("Status de pagamento não reconhecido");
        }

        payment.setPaymentStatus(paymentStatus);

        return repository.save(payment);
    }

    public void deletePayment(Integer debitCode, String paymentStatus){
            repository.deleteById(debitCode);
    }
}

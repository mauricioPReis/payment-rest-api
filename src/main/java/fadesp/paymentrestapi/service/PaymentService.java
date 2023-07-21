package fadesp.paymentrestapi.service;

import java.util.*;

import fadesp.exception.GenericException;
import fadesp.paymentrestapi.model.Payment;
import fadesp.paymentrestapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Long creatPayment(Payment payment) {
        List<String> validPaymentMethods = Arrays.asList("boleto", "pix", "cartao_credito", "cartao_debito");
        if (validPaymentMethods.equals(payment.getPaymentMethod()) || payment.getPaymentMethod() == null || payment.getPaymentMethod() == "") {
            throw new GenericException("medodo te pagamento invalido");
        }
        return repository.save(payment).getDebitCode();
    }

    public List<Payment> getPayments() {
        return repository.findAll();
    }

    public Optional<Payment> getPaymentById(Integer debitCode) {
        return repository.findById(debitCode);
    }

    public List<Payment> getPaymentByPayerType(String payerType) {
        return repository.findByPayerType(payerType);
    }

    public List<Payment> getPaymentByPaymentStatus(String paymentStatus) {
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

    public void deletePayment(Integer debitCode) {
        Optional<Payment> paymentOptional = repository.findById(debitCode);
        if (paymentOptional.isPresent()) { // verifica se o pagamento existe
            Payment payment = paymentOptional.get();
            if (payment.getPaymentStatus().equals("pendente_processamento")) { // verifica se o status é pendente de processamento
                repository.deleteById(debitCode);
                throw new RuntimeException("Pagamento foi " + debitCode + " excluido com sucesso");
            } else {
                throw new RuntimeException("Não é possível excluir um pagamento com status diferente de 'pendente_processamento'");
            }
        } else {
            System.out.println("Pagamento não encontrado");
            return;
        }
    }
}

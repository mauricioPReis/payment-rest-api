package fadesp.paymentrestapi.service.impl;

import com.fasterxml.jackson.annotation.Nulls;
import fadesp.paymentrestapi.handlers.RequiredField;
import fadesp.paymentrestapi.model.Payment;
import fadesp.paymentrestapi.repository.PaymentRepository;
import fadesp.paymentrestapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void createPayment(Payment payment) {
        if (payment.getPayerType() == null || payment.getPayerType() == ""){
            throw new RequiredField("CPF/CNPJ");
        } else if (payment.getPaymentMethod() == null || payment.getPaymentMethod() == "") {
            throw new RequiredField("Método de Pagamento");
        }else {
            PaymentRepository.save(payment);
        }
    }

    @Override
    public void editPayment(Payment payment, int debitCode) {

    }

    @Override
    public Payment fetchPaymentById(int debitCode) {
        return null;
    }

    @Override
    public Payment fetchPaymentByPayerType(String payerType) {
        return null;
    }

    @Override
    public Payment fetchPaymentByStatus(String paymentStatus) {
        return null;
    }

    @Override
    public Iterable<Payment> searchAllPayments() {
        return null;
    }
}

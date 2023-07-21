package fadesp.paymentrestapi.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "debitCode")
    private long debitCode;

    @Column(name = "payerType")
    @CPF(message = "Campo invalido")
    private String payerType;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "valuePayment")
    private double valuePayment;

    @Column(name = "paymentStatus")
    private String paymentStatus = "pendente_processamento";

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getDebitCode() {
        return debitCode;
    }

    public void setDebitCode(int debitCode) {
        this.debitCode = debitCode;
    }

    public String getPayerType() {
        return payerType;
    }

    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getValuePayment() {
        return valuePayment;
    }

    public void setValuePayment(double valuePayment) {
        this.valuePayment = valuePayment;
    }
}
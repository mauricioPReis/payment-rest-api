package fadesp.paymentrestapi.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int debitCode;

    @Column(name = "payerType", nullable = false) /*Cpf ou CNPJ*/
    private String payerType;

    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "valuePayment", nullable = false)
    private double valuePayment;

    @Column(name= "paymentStatus")
    private String paymentStatus = "Pendente de Processamento";

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getDebitCode() {
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
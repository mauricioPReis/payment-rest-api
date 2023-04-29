package fadesp.paymentrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int debitCode;

    @Column(name = "payerType", nullable = false)
    private char payerType;

    @Column(name = "paymentMethod", nullable = false)
    private char paymentMethod;

    @Column(name = "cardNumber")
    private char cardNumber;

    @Column(name = "valuePayment", nullable = false)
    private double valuePayment;

    public int getDebitCode() {
        return debitCode;
    }

    public void setDebitCode(int debitCode) {
        this.debitCode = debitCode;
    }

    public char getPayerType() {
        return payerType;
    }

    public void setPayerType(char payerType) {
        this.payerType = payerType;
    }

    public char getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(char paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public char getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(char cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getValuePayment() {
        return valuePayment;
    }

    public void setValuePayment(double valuePayment) {
        this.valuePayment = valuePayment;
    }
}
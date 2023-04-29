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
}
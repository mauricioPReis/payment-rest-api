package fadesp.paymentrestapi.http.controller;

import fadesp.paymentrestapi.model.Payment;
import fadesp.paymentrestapi.service.PaymentService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<List<Payment>> addPayments(@RequestBody List<Payment> payments){
        return new ResponseEntity<>(
                service.savePayment(payments),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<>(
                service.getPayments(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{debitCode}")
    public ResponseEntity<Optional<Payment>> getSpecificPayment(@PathVariable Integer debitCode){
        return new ResponseEntity<Optional<Payment>>(
                service.getPaymentById(debitCode),
                HttpStatus.OK
        );
    }

    @GetMapping("search/{payerType}")
    public ResponseEntity<List<Payment>> getSpecificPaymentType(@PathVariable String payerType){
        return new ResponseEntity<List<Payment>>(
                service.getPaymentByPayerType(payerType),
                HttpStatus.OK
        );
    }

    @GetMapping("search/{paymentStatus}")
    public ResponseEntity<List<Payment>> getSpecificPaymentStatus(@PathVariable String paymentStatus){
        return new ResponseEntity<List<Payment>>(
                service.getPaymentByPaymentStatus(paymentStatus),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(
                service.updatePayment(payment),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer debitCode, String paymentStatus){
        service.deletePayment(debitCode, paymentStatus);
        return new ResponseEntity<Void>(
                HttpStatus.OK
        );
    }
}
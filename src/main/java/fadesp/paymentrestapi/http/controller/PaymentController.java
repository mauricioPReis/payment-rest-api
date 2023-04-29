package fadesp.paymentrestapi.http.controller;

import fadesp.paymentrestapi.entity.Payment;
import fadesp.paymentrestapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

    @Autowired
    private PaymentRepository er;

    @RequestMapping(value ="/receivePayment", method = RequestMethod.GET)
    public String form() {
        return "/api/payment";
    }

    @RequestMapping(value ="/receivePayment", method = RequestMethod.POST)
    public String form(Payment payment) {

        er.save(payment);

        return "redirect:/receivePayment";
    }
}
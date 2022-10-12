package si5.cloud.h.paymentservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si5.cloud.h.paymentservice.Component.PaymentComponent;
import si5.cloud.h.paymentservice.model.Payment;

@RestController
@RequestMapping(path = PaymenController.BASE_URI)
public class PaymenController {

    public static final String BASE_URI = "pay";

    @Autowired
    PaymentComponent paymentComponent;

    @PostMapping
    public ResponseEntity<Boolean> pay(@RequestBody Payment p){
        return ResponseEntity.ok(paymentComponent.pay(p));
    }

}

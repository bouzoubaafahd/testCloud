package si5.cloud.h.paymentservice.Component;


import org.springframework.stereotype.Component;
import si5.cloud.h.paymentservice.model.Payment;

@Component
public class PaymentComponent {


   public boolean pay(Payment payment){
        if(payment.getCreditCard().length() != 16){
            return false;
        }
        return true;
    }


}

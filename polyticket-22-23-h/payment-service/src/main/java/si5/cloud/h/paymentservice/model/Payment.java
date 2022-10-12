package si5.cloud.h.paymentservice.model;

import javax.validation.constraints.Pattern;

public class Payment {

    String name;

    String creditCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Payment(String name, String creditCard) {
        this.name = name;
        this.creditCard = creditCard;
    }
}

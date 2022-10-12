package si5.cloud.h.blockandbookservice.controller.DTO;

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

package si5.cloud.h.blockandbookservice.controller.DTO;

public class BookingProcessDTO {

    Payment payment;

    String holder;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public BookingProcessDTO(Payment payment, String holder) {
        this.payment = payment;
        this.holder = holder;
    }
}

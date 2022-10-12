package si5.cloud.h.blockandbookservice.controller.DTO;

public class TicketDto {


    String type; // classic, e-ticket, nominatif

    int howMany;


    public TicketDto(String type, int howMany) {
        this.type = type;
        this.howMany = howMany;
    }

    public TicketDto() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
}

package si5.cloud.h.blockandbookservice.models;


import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    String type; // classic, e-ticket, nominatif

    int howMany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Ticket(String type, int howMany) {
        this.type = type;
        this.howMany = howMany;
    }

    public Ticket() {

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

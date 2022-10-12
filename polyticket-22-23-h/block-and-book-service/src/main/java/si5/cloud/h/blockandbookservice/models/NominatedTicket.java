package si5.cloud.h.blockandbookservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class NominatedTicket{
    @Id
    @GeneratedValue
    private Long id;

    String type; // classic, e-ticket, nominatif

    int howMany;

    @ElementCollection
    List<String> names = new ArrayList<>();

    public NominatedTicket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public NominatedTicket(String type, int howMany, List<String> names) {
        this.type = type;
        this.howMany = howMany;
        this.names = names;
    }
}

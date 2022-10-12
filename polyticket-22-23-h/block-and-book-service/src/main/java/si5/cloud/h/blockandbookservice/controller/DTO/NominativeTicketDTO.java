package si5.cloud.h.blockandbookservice.controller.DTO;

import java.util.ArrayList;
import java.util.List;

public class NominativeTicketDTO {

    String type; // classic, e-ticket, nominatif

    int howMany;

    List<String> names = new ArrayList<>();

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

    public NominativeTicketDTO(String type, int howMany, List<String> names) {
        this.type = type;
        this.howMany = howMany;
        this.names = names;
    }
}

package si5.cloud.h.blockandbookservice.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    @OneToMany(cascade=CascadeType.ALL)
    List<Ticket> ticketList;

    @OneToMany(cascade=CascadeType.ALL)
    List<NominatedTicket> nominatedTickets;


    public void setNominatedTickets(List<NominatedTicket> nominatedTickets) {
        this.nominatedTickets = nominatedTickets;
    }

    public List<NominatedTicket> getNominatedTickets() {
        return nominatedTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}

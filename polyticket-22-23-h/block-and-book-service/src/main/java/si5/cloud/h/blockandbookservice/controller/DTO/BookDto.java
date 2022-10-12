package si5.cloud.h.blockandbookservice.controller.DTO;

import java.util.ArrayList;
import java.util.List;

public class BookDto {

    String name;

    List<TicketDto> tickets = new ArrayList<>();

    List<NominativeTicketDTO> nominativeTicketDTOS = new ArrayList<>();

    public BookDto(String name, List<TicketDto> tickets, List<NominativeTicketDTO> nominativeTicketDTOS) {
        this.name = name;
        this.tickets = tickets;
        this.nominativeTicketDTOS = nominativeTicketDTOS;
    }

    public List<NominativeTicketDTO> getNominativeTicketDTOS() {
        return nominativeTicketDTOS;
    }

    public void setNominativeTicketDTOS(List<NominativeTicketDTO> nominativeTicketDTOS) {
        this.nominativeTicketDTOS = nominativeTicketDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }
}

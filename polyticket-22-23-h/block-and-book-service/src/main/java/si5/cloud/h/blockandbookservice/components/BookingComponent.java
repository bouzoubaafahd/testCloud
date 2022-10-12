package si5.cloud.h.blockandbookservice.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import si5.cloud.h.blockandbookservice.controller.DTO.BookDto;
import si5.cloud.h.blockandbookservice.controller.DTO.NominativeTicketDTO;
import si5.cloud.h.blockandbookservice.controller.DTO.TicketDto;
import si5.cloud.h.blockandbookservice.models.Booking;
import si5.cloud.h.blockandbookservice.models.NominatedTicket;
import si5.cloud.h.blockandbookservice.models.Ticket;
import si5.cloud.h.blockandbookservice.repository.BookingRepository;
import si5.cloud.h.blockandbookservice.repository.NomitedTicketRepository;
import si5.cloud.h.blockandbookservice.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingComponent {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    NomitedTicketRepository nomitedTicketRepository;

    List<Booking> bookings = new ArrayList<>();

    public Booking createBooking(BookDto bookDto){
        Booking booking = new Booking();
        booking.setName(bookDto.getName());
        booking.setTicketList(createTickets( bookDto.getTickets()));
        booking.setNominatedTickets(createNominatedTickets(bookDto.getNominativeTicketDTOS()));
        bookings.add(booking);
        return booking;
    }

    private List<Ticket> createTickets(List<TicketDto> ticketDtos){
        List<Ticket> ticket = new ArrayList<>();
        for(TicketDto ticketDto : ticketDtos){
                ticket.add(new Ticket(ticketDto.getType() , ticketDto.getHowMany()));
        }

        return ticket;
    }

    private List<NominatedTicket> createNominatedTickets(List<NominativeTicketDTO> ticketDtos){
        List<NominatedTicket> ticket = new ArrayList<>();
        for(NominativeTicketDTO ticketDto : ticketDtos){
            ticket.add(new NominatedTicket(ticketDto.getType() , ticketDto.getHowMany(), ticketDto.getNames()));
        }

        return ticket;
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId){
        return bookingRepository.findBookingById(bookingId).get();
    }

    public List<NominatedTicket> getNomTickets(){
     return    nomitedTicketRepository.findAll();
    }

    public List<Ticket> getTickets(){
        return   ticketRepository.findAll();
    }

    public Booking getBooking(String name){
        for(Booking booking : bookings){
            if(booking.getName().equals(name)){
                return booking;
            }
        }
        return null;
    }

    public Booking processBooking(String name){
        Booking booking = getBooking(name);
        bookingRepository.save(booking);
        return booking;
    }
}

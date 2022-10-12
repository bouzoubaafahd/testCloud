package si5.cloud.h.blockandbookservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import si5.cloud.h.blockandbookservice.components.BookingComponent;
import si5.cloud.h.blockandbookservice.controller.DTO.BookDto;
import si5.cloud.h.blockandbookservice.controller.DTO.BookingProcessDTO;
import si5.cloud.h.blockandbookservice.controller.DTO.NominativeTicketDTO;
import si5.cloud.h.blockandbookservice.controller.DTO.TicketDto;
import si5.cloud.h.blockandbookservice.models.Booking;
import si5.cloud.h.blockandbookservice.models.NominatedTicket;
import si5.cloud.h.blockandbookservice.models.Ticket;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = BookAndBlockController.BASE_URI)
public class BookAndBlockController {

    public static final String BASE_URI = "booking";



    @Autowired
    BookingComponent book;

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(BookAndBlockController.class);

    public static final String EVENT_URI = "http://localhost:8080/events/";

    public static final String BLOCK_URI = "blockTicket";

    public static final String UNBLOCK_URI = "unblockTicket";

    public static final String PAY_URI = "http://localhost:3001/pay";



    @PostMapping(value = "/bookTickets" ,consumes = APPLICATION_JSON_VALUE , produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> bookTicket(@RequestBody BookDto bookDTO){
      ResponseEntity<String> blockingStatus = restTemplate.getForEntity(EVENT_URI + BLOCK_URI , String.class );
      logger.info(blockingStatus.getBody());

      if(blockingStatus.getStatusCode() == HttpStatus.OK){
          book.createBooking(bookDTO);
          return ResponseEntity.ok(true);
      }else{
          return ResponseEntity.ok(false);
      }
    }

    @PostMapping(value = "/process")
    public ResponseEntity<Booking> process(@RequestBody BookingProcessDTO processBooking){

        ResponseEntity<Boolean> paymentStatus = restTemplate.postForEntity(PAY_URI , processBooking.getPayment() , Boolean.class);
        ResponseEntity<String> unblock = restTemplate.getForEntity(EVENT_URI + UNBLOCK_URI , String.class );

        if(Boolean.TRUE.equals(paymentStatus.getBody())){
            return ResponseEntity.ok(book.processBooking(processBooking.getHolder()));
        }else{
            return null;
        }




    }


    @GetMapping(value = "/bookings" , produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Booking>> getBookings(){
        return ResponseEntity.ok(book.getAllBookings());
    }
    @GetMapping(value = "/bookings/{bookingId}" , produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId){
        return ResponseEntity.ok(book.getBookingById(bookingId));
    }

    @GetMapping("/test")
    public ResponseEntity<BookDto> test(){
        List<TicketDto> ticketDtoList = new ArrayList<>();
        List<NominativeTicketDTO> nominativeTicketDTOList = new ArrayList<>();
        List<String> names = new ArrayList<>();
        ticketDtoList.add(new TicketDto("classic" , 3));
        ticketDtoList.add(new TicketDto("e-ticket" , 3));
        names.add("Fahde");
        nominativeTicketDTOList.add(new NominativeTicketDTO("nominative", 1 , names));

        return ResponseEntity.ok(new BookDto("Amine" , ticketDtoList , nominativeTicketDTOList));
    }

    @GetMapping("/tik")
    public ResponseEntity<List<Ticket>> getTickets(){
        return ResponseEntity.ok(book.getTickets());
    }

    @GetMapping("/nom")
    public ResponseEntity<List<NominatedTicket>> getNomTickets(){
        return ResponseEntity.ok(book.getNomTickets());
    }
}

package si5.cloud.h.blockandbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si5.cloud.h.blockandbookservice.models.NominatedTicket;
import si5.cloud.h.blockandbookservice.models.Ticket;

public interface NomitedTicketRepository extends JpaRepository<NominatedTicket, Long> {
}

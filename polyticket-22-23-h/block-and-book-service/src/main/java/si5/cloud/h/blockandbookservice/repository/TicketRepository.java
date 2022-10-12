package si5.cloud.h.blockandbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si5.cloud.h.blockandbookservice.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

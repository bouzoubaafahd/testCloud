package si5.cloud.h.blockandbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si5.cloud.h.blockandbookservice.models.Booking;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findBookingById(Long id);
}

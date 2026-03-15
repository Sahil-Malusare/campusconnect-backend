package campusconnect.backend.repository;

import campusconnect.backend.entity.EventPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPaymentRepository extends JpaRepository<EventPayment, Long> {
}
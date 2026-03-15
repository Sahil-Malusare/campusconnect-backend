package campusconnect.backend.repository;

import campusconnect.backend.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceType, Long> {

    Optional<ServiceType> findByService(String service);
}

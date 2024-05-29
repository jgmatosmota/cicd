package cosmeet.backendjava.infraestructure.persistence.access;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<AccessEntity, Long>{
}

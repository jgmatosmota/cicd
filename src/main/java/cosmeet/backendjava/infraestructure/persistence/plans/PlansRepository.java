package cosmeet.backendjava.infraestructure.persistence.plans;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<PlansEntity, Long>{
}

package cosmeet.backendjava.infraestructure.persistence.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
}

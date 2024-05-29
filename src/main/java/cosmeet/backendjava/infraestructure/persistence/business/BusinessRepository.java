package cosmeet.backendjava.infraestructure.persistence.business;

import cosmeet.backendjava.domain.entity.Business;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessRepository extends JpaRepository<BusinessEntity, Long>{
    @Transactional
    @Modifying
    @Query("UPDATE BusinessEntity b SET b.name = :name, b.email = :email, b.phone = :phone, b.occupation = :occupation, b.about = :about, b.photo = :photo WHERE b.id = :id")
    void updateById(@Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("occupation") String occupation, @Param("about") String about, @Param("photo") String photo, @Param("id") Long id);

    List<BusinessEntity> findByNameContainingIgnoreCase(String name);
}

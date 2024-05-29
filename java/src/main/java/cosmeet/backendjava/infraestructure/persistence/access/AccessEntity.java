package cosmeet.backendjava.infraestructure.persistence.access;

import cosmeet.backendjava.domain.entity.Business;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "access")
public class AccessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @OneToOne
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;
}

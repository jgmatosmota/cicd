package cosmeet.backendjava.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String street;

    private Integer number;

    private String neighborhood;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private String latitude;

    private String longitude;

    @OneToOne
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;
}
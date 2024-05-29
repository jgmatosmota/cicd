package cosmeet.backendjava.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank
    private String phone;

    @CNPJ
    private String cnpj;

    private String occupation;
    private String about;
    private String photo;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "plans_id", referencedColumnName = "id")
    private Plans plans;
}
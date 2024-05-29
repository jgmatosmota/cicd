package cosmeet.backendjava.domain.dto.business;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record GetBusinessResponse (
    Long id,
    String name,
    String email,
    String phone,
    String cnpj,
    String occupation,
    String about,
    String photo
) {
}

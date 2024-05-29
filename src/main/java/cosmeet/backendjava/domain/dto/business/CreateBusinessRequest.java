package cosmeet.backendjava.domain.dto.business;

import cosmeet.backendjava.domain.entity.Plans;
import cosmeet.backendjava.domain.entity.User;

public record CreateBusinessRequest (
    String name,
    String email,
    String phone,
    String cnpj,
    String about,
    String photo,
    String occupation,
    User user,
    Plans plans
) {
}

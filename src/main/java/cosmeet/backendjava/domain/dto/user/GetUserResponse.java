package cosmeet.backendjava.domain.dto.user;

import java.util.UUID;

public record GetUserResponse (
        Long id,
        String name,
        String email
) {
}

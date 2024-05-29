package cosmeet.backendjava.domain.dto.user;

public record GetUserRequest (
        String email,
        String password
) {
}

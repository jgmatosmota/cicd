package cosmeet.backendjava.domain.dto.user;

public record CreateUserRequest (
        String name,
        String email,
        String password
) {
}

package cosmeet.backendjava.domain.dto.user;

public record CreateUserResponse (
        String name,
        String email
) {
}

package cosmeet.backendjava.domain.dto.business;

public record CreateBusinessResponse (
    Long id,
    String name,
    String email,
    String photo,
    String occupation,
    String about,
    String phone
) {
}

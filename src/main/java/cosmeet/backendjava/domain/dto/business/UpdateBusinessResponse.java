package cosmeet.backendjava.domain.dto.business;

public record UpdateBusinessResponse (
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

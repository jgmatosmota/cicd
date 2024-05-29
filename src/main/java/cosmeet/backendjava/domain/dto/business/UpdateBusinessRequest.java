package cosmeet.backendjava.domain.dto.business;

import cosmeet.backendjava.domain.entity.Business;
import org.springframework.web.multipart.MultipartFile;

public record UpdateBusinessRequest (
    MultipartFile file,
    Business business
) {
}

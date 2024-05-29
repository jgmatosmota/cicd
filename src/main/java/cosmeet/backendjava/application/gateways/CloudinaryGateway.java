package cosmeet.backendjava.application.gateways;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryGateway {
    String uploadFile(MultipartFile file) throws Exception;
}

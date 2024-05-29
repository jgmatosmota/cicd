package cosmeet.backendjava.application.usecases.cloudinary;

import com.cloudinary.Cloudinary;
import cosmeet.backendjava.application.gateways.CloudinaryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UploadFileInterface implements CloudinaryGateway {
    private final Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        return cloudinary.uploader()
                .upload(file.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
    }
}

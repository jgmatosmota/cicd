package cosmeet.backendjava.infraestructure.controllers.cloudinary;

import cosmeet.backendjava.application.usecases.business.CreateBusinessInterface;
import cosmeet.backendjava.application.usecases.cloudinary.UploadFileInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class CreateImageController {
    private final UploadFileInterface uploadFileInterface;

    public CreateImageController(UploadFileInterface uploadFileInterface) {
        this.uploadFileInterface = uploadFileInterface;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String url = uploadFileInterface.uploadFile(file);
        return url;
    }
}

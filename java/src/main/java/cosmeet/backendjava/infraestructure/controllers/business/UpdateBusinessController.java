package cosmeet.backendjava.infraestructure.controllers.business;

import cosmeet.backendjava.application.usecases.address.CreateAddressInterface;
import cosmeet.backendjava.application.usecases.business.GetBusinessInterface;
import cosmeet.backendjava.application.usecases.business.UpdateBusinessInterface;
import cosmeet.backendjava.application.usecases.cloudinary.UploadFileInterface;
import cosmeet.backendjava.domain.dto.business.BusinessDTOMapper;
import cosmeet.backendjava.domain.dto.business.UpdateBusinessRequest;
import cosmeet.backendjava.domain.dto.business.UpdateBusinessResponse;
import cosmeet.backendjava.domain.entity.Business;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/business")
public class UpdateBusinessController {
     private final UpdateBusinessInterface updateBusinessInterface;
     private final GetBusinessInterface getBusinessInterface;
     private final CreateAddressInterface createAddressInterface;
     private final UploadFileInterface uploadFileInterface;

     public UpdateBusinessController(
             UpdateBusinessInterface updateBusinessInterface,
             GetBusinessInterface getBusinessInterface,
             CreateAddressInterface createAddressInterface,
             UploadFileInterface uploadFileInterface) {
        this.updateBusinessInterface = updateBusinessInterface;
        this.getBusinessInterface = getBusinessInterface;
        this.createAddressInterface = createAddressInterface;
        this.uploadFileInterface = uploadFileInterface;
     }

     @PutMapping("/{id}")
     ResponseEntity<UpdateBusinessResponse> updateBusiness(
             @PathVariable("id") Long id,
             @RequestParam("file") MultipartFile file,
             @RequestParam("name") String name,
             @RequestParam("email") String email,
             @RequestParam("phone") String phone,
             @RequestParam("occupation") String occupation,
             @RequestParam("about") String about
             ) throws Exception {
         Business business = getBusinessInterface.getBusinessByUserId(id);
         if (business == null) {
             return ResponseEntity
                     .status(404)
                     .body(null);
         }

         String photo = uploadFileInterface.uploadFile(file);

         business.setName(name);
         business.setEmail(email);
         business.setPhone(phone);
         business.setOccupation(occupation);
         business.setAbout(about);
         business.setPhoto(photo);

         Business businessAtt = updateBusinessInterface.updateBusinessById(id, business);

         return ResponseEntity
                 .status(200)
                 .body(new BusinessDTOMapper().toUpdateResponse(businessAtt));
     }
}

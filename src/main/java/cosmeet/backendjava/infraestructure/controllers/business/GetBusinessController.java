package cosmeet.backendjava.infraestructure.controllers.business;

import cosmeet.backendjava.application.usecases.business.GetBusinessInterface;
import cosmeet.backendjava.domain.dto.business.*;
import cosmeet.backendjava.domain.entity.Business;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class GetBusinessController {
    private final GetBusinessInterface getBusinessInterface;

    public GetBusinessController(GetBusinessInterface getBusinessInterfaces) {
        this.getBusinessInterface = getBusinessInterfaces;
    }

    @GetMapping("/{id}")
    ResponseEntity<GetBusinessResponse> createBusiness(@Valid @PathVariable("id") Long id) {
        Business getBusiness = getBusinessInterface.getBusinessByUserId(id);

        return ResponseEntity
                .status(201)
                .body(new BusinessDTOMapper().toGetResponse(getBusiness));
    }
}

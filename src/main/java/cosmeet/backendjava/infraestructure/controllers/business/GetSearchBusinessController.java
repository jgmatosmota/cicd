package cosmeet.backendjava.infraestructure.controllers.business;

import cosmeet.backendjava.application.usecases.business.GetSearchBusinessInterface;
import cosmeet.backendjava.domain.dto.business.BusinessDTOMapper;
import cosmeet.backendjava.domain.dto.business.GetSearchBusinessResponse;
import cosmeet.backendjava.domain.entity.Business;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class GetSearchBusinessController {
    private final GetSearchBusinessInterface getSearchBusinessInterface;

    public GetSearchBusinessController(GetSearchBusinessInterface getSearchBusinessInterface) {
        this.getSearchBusinessInterface = getSearchBusinessInterface;
    }

     @GetMapping("/search")
     ResponseEntity<List<Business>> searchBusiness(@Valid @RequestParam("name") String name) {
         List<Business> getSearchBusiness = getSearchBusinessInterface.findByNameContainingIgnoreCase(name);

         return ResponseEntity
                 .status(200)
                 .body(getSearchBusiness);
     }
}

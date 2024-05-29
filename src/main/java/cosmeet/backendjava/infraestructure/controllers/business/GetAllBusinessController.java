package cosmeet.backendjava.infraestructure.controllers.business;

import cosmeet.backendjava.application.usecases.business.GetAllBusinessInterface;
import cosmeet.backendjava.domain.entity.Business;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class GetAllBusinessController {
    private final GetAllBusinessInterface getAllBusinessInterface;

    public GetAllBusinessController(GetAllBusinessInterface getAllBusinessInterface) {
        this.getAllBusinessInterface = getAllBusinessInterface;
    }

    @GetMapping
    ResponseEntity<List<Business>> getAllBusiness() {
        List<Business> getBusiness = getAllBusinessInterface.getAllBusiness();

        return ResponseEntity
                .status(200)
                .body(getBusiness);
    }
}

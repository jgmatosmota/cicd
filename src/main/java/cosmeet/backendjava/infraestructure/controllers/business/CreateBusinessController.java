package cosmeet.backendjava.infraestructure.controllers.business;

import cosmeet.backendjava.application.usecases.business.CreateBusinessInterface;
import cosmeet.backendjava.application.usecases.plans.GetPlansInterface;
import cosmeet.backendjava.application.usecases.user.CreateUserInterface;
import cosmeet.backendjava.domain.dto.business.BusinessDTOMapper;
import cosmeet.backendjava.domain.dto.business.CreateBusinessRequest;
import cosmeet.backendjava.domain.dto.business.CreateBusinessResponse;
import cosmeet.backendjava.domain.dto.user.CreateUserRequest;
import cosmeet.backendjava.domain.dto.user.UserDTOMapper;
import cosmeet.backendjava.domain.entity.Business;
import cosmeet.backendjava.domain.entity.Plans;
import cosmeet.backendjava.domain.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class CreateBusinessController {
    private final CreateBusinessInterface createBusinessInterface;
    private final GetPlansInterface getPlansInterface;
    private final CreateUserInterface createUserInterface;

    public CreateBusinessController(
            CreateBusinessInterface createBusinessInterface,
            GetPlansInterface getPlansInterface,
            CreateUserInterface createUserInterface) {
        this.createBusinessInterface = createBusinessInterface;
        this.getPlansInterface = getPlansInterface;
        this.createUserInterface = createUserInterface;
    }

    @PostMapping
    ResponseEntity<CreateBusinessResponse> createBusiness(@Valid @RequestBody CreateBusinessRequest request) {
        Plans plans = getPlansInterface.getPlanById(request.plans().getId());

        CreateUserRequest requestUser = new CreateUserRequest(
                request.user().getName(),
                request.user().getEmail(),
                request.user().getPassword()
        );
        User user = new UserDTOMapper().toUser(requestUser);
        User createdUser = createUserInterface.createUser(user);

        Business business = new BusinessDTOMapper().toBusiness(request);
        business.setPlans(plans);
        business.setUser(createdUser);
        Business createdBusiness = createBusinessInterface.createBusiness(business);

        return ResponseEntity
                .status(201)
                .body(new BusinessDTOMapper().toCreateResponse(createdBusiness));
    }
}

package cosmeet.backendjava.infraestructure.controllers.user;

import cosmeet.backendjava.application.usecases.user.CreateUserInterface;
import cosmeet.backendjava.domain.dto.user.CreateUserRequest;
import cosmeet.backendjava.domain.dto.user.CreateUserResponse;
import cosmeet.backendjava.domain.dto.user.UserDTOMapper;
import cosmeet.backendjava.domain.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CreateUserController {
    private final CreateUserInterface createUserInterface;

    public CreateUserController(CreateUserInterface createUserInterface) {
        this.createUserInterface = createUserInterface;
    }

    @PostMapping
    ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = new UserDTOMapper().toUser(request);
        User createdUser = createUserInterface.createUser(user);

        return ResponseEntity
                .status(201)
                .body(new UserDTOMapper().toCreateResponse(createdUser));
    }
}

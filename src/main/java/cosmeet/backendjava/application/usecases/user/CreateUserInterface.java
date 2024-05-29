package cosmeet.backendjava.application.usecases.user;

import cosmeet.backendjava.application.gateways.UserGateway;
import cosmeet.backendjava.domain.entity.User;

public class CreateUserInterface {
    private final UserGateway userGateway;

    public CreateUserInterface(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        try {
            return userGateway.createUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user", e);
        }
    }
}

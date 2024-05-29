package cosmeet.backendjava.application.gateways;

import cosmeet.backendjava.domain.entity.User;

public interface UserGateway {
    User createUser(User user);
    User getUser(User user);

}

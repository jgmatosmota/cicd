package cosmeet.backendjava.main;

import cosmeet.backendjava.application.gateways.UserGateway;
import cosmeet.backendjava.application.usecases.user.CreateUserInterface;
import cosmeet.backendjava.application.usecases.user.GetUserInterface;
import cosmeet.backendjava.domain.dto.user.UserDTOMapper;
import cosmeet.backendjava.infraestructure.gateways.user.UserEntityMapper;
import cosmeet.backendjava.infraestructure.gateways.user.UserRepositoryGateway;
import cosmeet.backendjava.infraestructure.persistence.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUserInterface createUserUseCase(UserGateway userGateway) {
        return new CreateUserInterface(userGateway);
    }

    @Bean
    GetUserInterface getUserUseCase(UserGateway userGateway) {
        return new GetUserInterface(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}


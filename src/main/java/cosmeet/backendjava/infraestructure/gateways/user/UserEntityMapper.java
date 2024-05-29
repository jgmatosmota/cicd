package cosmeet.backendjava.infraestructure.gateways.user;

import cosmeet.backendjava.domain.entity.User;
import cosmeet.backendjava.infraestructure.persistence.user.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomainObj) {
        return new UserEntity(
                null,
                userDomainObj.getName(),
                userDomainObj.getEmail(),
                userDomainObj.getPassword()
        );
    }

    User toDomainObj(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }
}

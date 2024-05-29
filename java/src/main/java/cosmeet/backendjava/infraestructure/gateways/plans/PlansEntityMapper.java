package cosmeet.backendjava.infraestructure.gateways.plans;

import cosmeet.backendjava.domain.entity.Plans;
import cosmeet.backendjava.domain.entity.User;
import cosmeet.backendjava.infraestructure.persistence.plans.PlansEntity;
import cosmeet.backendjava.infraestructure.persistence.user.UserEntity;

public class PlansEntityMapper {
    PlansEntity toEntity(Plans userDomainObj) {
        return new PlansEntity(
                null,
                userDomainObj.getName(),
                userDomainObj.getPrice(),
                userDomainObj.getFavorite(),
                userDomainObj.getLimitSearch(),
                userDomainObj.getLimitCategory()
        );
    }

    Plans toDomainObj(PlansEntity plansEntity) {
        return new Plans(
                plansEntity.getId(),
                plansEntity.getName(),
                plansEntity.getPrice(),
                plansEntity.getFavorite(),
                plansEntity.getLimitSearch(),
                plansEntity.getLimitCategory()
        );
    }
}

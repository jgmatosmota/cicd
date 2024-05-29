package cosmeet.backendjava.infraestructure.gateways.business;

import cosmeet.backendjava.domain.entity.Business;
import cosmeet.backendjava.domain.entity.User;
import cosmeet.backendjava.infraestructure.persistence.business.BusinessEntity;
import cosmeet.backendjava.infraestructure.persistence.user.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessEntityMapper {
    BusinessEntity toEntity(Business userDomainObj) {
        return new BusinessEntity(
            null,
            userDomainObj.getName(),
            userDomainObj.getEmail(),
            userDomainObj.getPhone(),
            userDomainObj.getCnpj(),
            userDomainObj.getOccupation(),
            userDomainObj.getAbout(),
            userDomainObj.getPhoto(),
            userDomainObj.getUser(),
            userDomainObj.getPlans()
        );
    }

    Business toDomainObj(BusinessEntity businessEntity) {
        return new Business(
            businessEntity.getId(),
            businessEntity.getName(),
            businessEntity.getEmail(),
            businessEntity.getPhone(),
            businessEntity.getCnpj(),
            businessEntity.getOccupation(),
            businessEntity.getAbout(),
            businessEntity.getPhoto(),
            businessEntity.getUser(),
            businessEntity.getPlans()
        );
    }

    List<Business> toDomainObjList(List<BusinessEntity> businessEntities) {
        return businessEntities.stream().map(this::toDomainObj).collect(Collectors.toList());
    }
}

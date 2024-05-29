package cosmeet.backendjava.infraestructure.gateways.address;

import cosmeet.backendjava.domain.entity.Address;
import cosmeet.backendjava.domain.entity.Business;
import cosmeet.backendjava.infraestructure.persistence.address.AddressEntity;
import cosmeet.backendjava.infraestructure.persistence.business.BusinessEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class AddressEntityMapper {
    AddressEntity toEntity(Address userDomainObj) {
        return new AddressEntity(
                null,
                userDomainObj.getStreet(),
                userDomainObj.getNumber(),
                userDomainObj.getNeighborhood(),
                userDomainObj.getCity(),
                userDomainObj.getState(),
                userDomainObj.getCountry(),
                userDomainObj.getZipCode(),
                userDomainObj.getLatitude(),
                userDomainObj.getLongitude(),
                userDomainObj.getBusiness()

        );
    }
    Address toDomainObj(AddressEntity addressEntity) {
        return new Address(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getNeighborhood(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getCountry(),
                addressEntity.getZipCode(),
                addressEntity.getLatitude(),
                addressEntity.getLongitude(),
                addressEntity.getBusiness()
        );
    }
}

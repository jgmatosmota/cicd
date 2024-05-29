package cosmeet.backendjava.infraestructure.gateways.address;

import cosmeet.backendjava.application.gateways.AddressGateway;
import cosmeet.backendjava.domain.entity.Address;
import cosmeet.backendjava.infraestructure.persistence.address.AddressEntity;
import cosmeet.backendjava.infraestructure.persistence.address.AddressRepository;

public class AddressRepositoryGateway implements AddressGateway {
    private final AddressRepository addressRepository;
    private final AddressEntityMapper addressEntityMapper;

    public AddressRepositoryGateway(AddressRepository addressRepository, AddressEntityMapper addressEntityMapper) {
        this.addressRepository = addressRepository;
        this.addressEntityMapper = addressEntityMapper;
    }

    @Override
    public Address createAddress(Address address) {
        AddressEntity addressEntity = addressEntityMapper.toEntity(address);
        AddressEntity savedAddressEntity = addressRepository.save(addressEntity);

        return addressEntityMapper.toDomainObj(savedAddressEntity);
    }
}

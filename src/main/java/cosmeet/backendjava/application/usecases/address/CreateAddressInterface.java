package cosmeet.backendjava.application.usecases.address;

import cosmeet.backendjava.application.gateways.AddressGateway;
import cosmeet.backendjava.domain.entity.Address;

public class CreateAddressInterface {
    private final AddressGateway addressGateway;

    public CreateAddressInterface(AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    public Address createAddress(Address address) {
        try {
            return addressGateway.createAddress(address);
        } catch (Exception e) {
            throw new RuntimeException("Error creating business", e);
        }
    }
}

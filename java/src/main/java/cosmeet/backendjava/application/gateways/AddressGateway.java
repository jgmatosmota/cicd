package cosmeet.backendjava.application.gateways;

import cosmeet.backendjava.domain.entity.Address;
import cosmeet.backendjava.domain.entity.User;

public interface AddressGateway {
    Address createAddress(Address address);
}

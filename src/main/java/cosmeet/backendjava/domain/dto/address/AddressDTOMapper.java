package cosmeet.backendjava.domain.dto.address;

import cosmeet.backendjava.domain.dto.user.CreateUserRequest;
import cosmeet.backendjava.domain.entity.Address;

public class AddressDTOMapper {
    public Address toAddress(CreateAddressRequest request) {
        return new Address(
        );
    }
}

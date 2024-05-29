package cosmeet.backendjava.main;

import cosmeet.backendjava.application.gateways.AddressGateway;
import cosmeet.backendjava.application.gateways.PlansGateway;
import cosmeet.backendjava.application.usecases.address.CreateAddressInterface;
import cosmeet.backendjava.application.usecases.plans.GetPlansInterface;
import cosmeet.backendjava.domain.dto.address.AddressDTOMapper;
import cosmeet.backendjava.domain.dto.plans.PlansDTOMapper;
import cosmeet.backendjava.infraestructure.gateways.address.AddressEntityMapper;
import cosmeet.backendjava.infraestructure.gateways.address.AddressRepositoryGateway;
import cosmeet.backendjava.infraestructure.gateways.plans.PlansEntityMapper;
import cosmeet.backendjava.infraestructure.gateways.plans.PlansRepositoryGateway;
import cosmeet.backendjava.infraestructure.persistence.address.AddressRepository;
import cosmeet.backendjava.infraestructure.persistence.plans.PlansRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {
    @Bean
    CreateAddressInterface createAddressUseCase(AddressGateway addressGateway) {
        return new CreateAddressInterface(addressGateway);
    }

    @Bean
    AddressGateway addressGateway(AddressRepository addressRepository, AddressEntityMapper addressEntityMapper) {
        return new AddressRepositoryGateway(addressRepository, addressEntityMapper);
    }

    @Bean
    AddressEntityMapper addressEntityMapper() {
        return new AddressEntityMapper();
    }

    @Bean
    AddressDTOMapper addressDTOMapper() {
        return new AddressDTOMapper();
    }
}

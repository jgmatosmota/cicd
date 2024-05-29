package cosmeet.backendjava.main;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.application.usecases.business.*;
import cosmeet.backendjava.domain.dto.business.BusinessDTOMapper;
import cosmeet.backendjava.infraestructure.gateways.business.BusinessEntityMapper;
import cosmeet.backendjava.infraestructure.gateways.business.BusinessRepositoryGateway;
import cosmeet.backendjava.infraestructure.persistence.business.BusinessRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {
    @Bean
    CreateBusinessInterface createBusinessUseCase(BusinessGateway businessGateway) {
        return new CreateBusinessInterface(businessGateway);
    }

    @Bean
    GetAllBusinessInterface getAllBusinessUseCase(BusinessGateway businessGateway) {
        return new GetAllBusinessInterface(businessGateway);
    }

    @Bean
    GetSearchBusinessInterface getSearchBusinessInterface(BusinessGateway businessGateway) {
        return new GetSearchBusinessInterface(businessGateway);
    }

    @Bean
    GetBusinessInterface getBusinessInterface(BusinessGateway businessGateway) {
        return new GetBusinessInterface(businessGateway);
    }

    @Bean
    UpdateBusinessInterface updateBusinessInterface(BusinessGateway businessGateway) {
        return new UpdateBusinessInterface(businessGateway);
    }

    @Bean
    BusinessGateway businessGateway(BusinessRepository businessRepository, BusinessEntityMapper businessEntityMapper) {
        return new BusinessRepositoryGateway(businessRepository, businessEntityMapper);
    }

    @Bean
    BusinessEntityMapper businessEntityMapper() {
        return new BusinessEntityMapper();
    }

    @Bean
    BusinessDTOMapper businessDTOMapper() {
        return new BusinessDTOMapper();
    }
}

package cosmeet.backendjava.main;

import cosmeet.backendjava.application.gateways.PlansGateway;
import cosmeet.backendjava.application.usecases.plans.GetPlansInterface;
import cosmeet.backendjava.domain.dto.plans.PlansDTOMapper;
import cosmeet.backendjava.infraestructure.gateways.plans.PlansEntityMapper;
import cosmeet.backendjava.infraestructure.gateways.plans.PlansRepositoryGateway;
import cosmeet.backendjava.infraestructure.persistence.plans.PlansRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlansConfig {
    @Bean
    GetPlansInterface getPlansUseCase(PlansGateway plansGateway) {
        return new GetPlansInterface(plansGateway);
    }

    @Bean
    PlansGateway plansGateway(PlansRepository plansRepository, PlansEntityMapper plansEntityMapper) {
        return new PlansRepositoryGateway(plansRepository, plansEntityMapper);
    }

    @Bean
    PlansEntityMapper plansEntityMapper() {
        return new PlansEntityMapper();
    }

    @Bean
    PlansDTOMapper plansDTOMapper() {
        return new PlansDTOMapper();
    }
}

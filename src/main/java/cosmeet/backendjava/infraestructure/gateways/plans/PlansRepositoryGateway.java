package cosmeet.backendjava.infraestructure.gateways.plans;

import cosmeet.backendjava.application.gateways.PlansGateway;
import cosmeet.backendjava.domain.entity.Plans;
import cosmeet.backendjava.infraestructure.gateways.user.UserEntityMapper;
import cosmeet.backendjava.infraestructure.persistence.plans.PlansEntity;
import cosmeet.backendjava.infraestructure.persistence.plans.PlansRepository;
import cosmeet.backendjava.infraestructure.persistence.user.UserRepository;

public class PlansRepositoryGateway implements PlansGateway {
    private final PlansRepository plansRepository;
    private final PlansEntityMapper plansEntityMapper;

    public PlansRepositoryGateway(PlansRepository plansRepository, PlansEntityMapper plansEntityMapper) {
        this.plansRepository = plansRepository;
        this.plansEntityMapper = plansEntityMapper;
    }

    @Override
    public Plans getPlanById(Long planId) {
        PlansEntity plans = plansRepository.findById(planId).orElseThrow(RuntimeException::new);
        return plansEntityMapper.toDomainObj(plans);
    }
}

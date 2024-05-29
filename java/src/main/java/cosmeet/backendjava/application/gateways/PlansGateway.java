package cosmeet.backendjava.application.gateways;

import cosmeet.backendjava.domain.entity.Plans;

public interface PlansGateway {
    Plans getPlanById(Long planId);
}

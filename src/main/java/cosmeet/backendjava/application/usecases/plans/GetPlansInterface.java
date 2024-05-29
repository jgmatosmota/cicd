package cosmeet.backendjava.application.usecases.plans;

import cosmeet.backendjava.application.gateways.PlansGateway;
import cosmeet.backendjava.domain.entity.Plans;

public class GetPlansInterface {
    private final PlansGateway plansGateway;

    public GetPlansInterface(PlansGateway plansGateway) {
        this.plansGateway = plansGateway;
    }

    public Plans getPlanById(Long plansId) {
        try {
            return plansGateway.getPlanById(plansId);
        } catch (Exception e) {
            throw new RuntimeException("Error getting business", e);
        }
    }
}

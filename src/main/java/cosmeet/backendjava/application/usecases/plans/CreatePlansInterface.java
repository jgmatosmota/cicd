package cosmeet.backendjava.application.usecases.plans;

import cosmeet.backendjava.application.gateways.PlansGateway;

public class CreatePlansInterface {
    private final PlansGateway plansGateway;

    public CreatePlansInterface(PlansGateway plansGateway) {
        this.plansGateway = plansGateway;
    }
}

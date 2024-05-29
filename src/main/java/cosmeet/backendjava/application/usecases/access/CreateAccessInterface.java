package cosmeet.backendjava.application.usecases.access;

import cosmeet.backendjava.application.gateways.AccessGateway;

public class CreateAccessInterface {
    private final AccessGateway accessGateway;

    public CreateAccessInterface(AccessGateway accessGateway) {
        this.accessGateway = accessGateway;
    }
}

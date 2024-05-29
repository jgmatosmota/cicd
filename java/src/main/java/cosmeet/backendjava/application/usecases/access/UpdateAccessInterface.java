package cosmeet.backendjava.application.usecases.access;

import cosmeet.backendjava.application.gateways.AccessGateway;

public class UpdateAccessInterface {
    private final AccessGateway accessGateway;

    public UpdateAccessInterface(AccessGateway accessGateway) {
        this.accessGateway = accessGateway;
    }
}

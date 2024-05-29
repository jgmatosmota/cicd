package cosmeet.backendjava.application.usecases.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;

public class UpdateBusinessInterface {
    private final BusinessGateway businessGateway;

    public UpdateBusinessInterface(BusinessGateway businessGateway) {
        this.businessGateway = businessGateway;
    }

    public Business updateBusinessById(Long businessId, Business business) {
        try {
            return businessGateway.updateBusinessById(businessId, business);
        } catch (Exception e) {
            throw new RuntimeException("Error updating business", e);
        }
    }
}

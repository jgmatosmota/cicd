package cosmeet.backendjava.application.usecases.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;

public class CreateBusinessInterface {
    private final BusinessGateway businessGateway;

    public CreateBusinessInterface(BusinessGateway businessGateway) {
        this.businessGateway = businessGateway;
    }

    public Business createBusiness(Business business) {
        try {
            return businessGateway.createBusiness(business);
        } catch (Exception e) {
            throw new RuntimeException("Error creating business", e);
        }
    }
}

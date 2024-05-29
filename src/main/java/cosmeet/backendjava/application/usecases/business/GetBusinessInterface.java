package cosmeet.backendjava.application.usecases.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;
import org.springframework.stereotype.Service;

public class GetBusinessInterface {
    private final BusinessGateway businessGateway;

    public GetBusinessInterface(BusinessGateway businessGateway) {
        this.businessGateway = businessGateway;
    }

    public Business getBusinessByUserId(Long businessId) {
        try {
            return businessGateway.getBusinessByUserId(businessId);
        } catch (Exception e) {
            throw new RuntimeException("Error getting business", e);
        }
    }
}

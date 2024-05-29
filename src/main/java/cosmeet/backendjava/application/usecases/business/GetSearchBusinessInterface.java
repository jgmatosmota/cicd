package cosmeet.backendjava.application.usecases.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;
import org.springframework.stereotype.Service;

import java.util.List;

public class GetSearchBusinessInterface {
    private final BusinessGateway businessGateway;

    public GetSearchBusinessInterface(BusinessGateway businessGateway) {
        this.businessGateway = businessGateway;
    }

    public List<Business> findByNameContainingIgnoreCase(String name) {
        try {
            return businessGateway.findByNameContainingIgnoreCase(name);
        } catch (Exception e) {
            throw new RuntimeException("Error getting business", e);
        }
    }
}

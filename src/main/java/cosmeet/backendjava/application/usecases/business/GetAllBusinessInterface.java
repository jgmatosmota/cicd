package cosmeet.backendjava.application.usecases.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBusinessInterface {
    private final BusinessGateway businessGateway;

    public GetAllBusinessInterface(BusinessGateway businessGateway) {
        this.businessGateway = businessGateway;
    }

    public List<Business> getAllBusiness() {
        try {
            return businessGateway.getAllBusiness();
        } catch (Exception e) {
            throw new RuntimeException("Error getting business", e);
        }
    }
}

package cosmeet.backendjava.application.gateways;

import cosmeet.backendjava.domain.entity.Business;

import java.util.List;

public interface BusinessGateway {
    Business createBusiness(Business business);
    Business getBusinessByUserId(Long businessId);
    List<Business> getAllBusiness();
    Business updateBusinessById(Long businessId, Business business);
    List<Business> findByNameContainingIgnoreCase(String name);

}

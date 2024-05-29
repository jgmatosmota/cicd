package cosmeet.backendjava.infraestructure.gateways.business;

import cosmeet.backendjava.application.gateways.BusinessGateway;
import cosmeet.backendjava.domain.entity.Business;
import cosmeet.backendjava.infraestructure.persistence.business.BusinessEntity;
import cosmeet.backendjava.infraestructure.persistence.business.BusinessRepository;

import java.util.List;

public class BusinessRepositoryGateway implements BusinessGateway {
    private final BusinessRepository businessRepository;
    private final BusinessEntityMapper businessEntityMapper;

    public BusinessRepositoryGateway(BusinessRepository businessRepository, BusinessEntityMapper businessEntityMapper) {
        this.businessRepository = businessRepository;
        this.businessEntityMapper = businessEntityMapper;
    }

    @Override
    public Business createBusiness(Business business) {
        BusinessEntity businessEntity = businessEntityMapper.toEntity(business);
        BusinessEntity savedBusinessEntity = businessRepository.save(businessEntity);

        return businessEntityMapper.toDomainObj(savedBusinessEntity);
    }

    @Override
    public Business getBusinessByUserId(Long businessId) {
        BusinessEntity businessEntity = businessRepository.findById(businessId).orElse(null);
        return businessEntityMapper.toDomainObj(businessEntity);
    }

    @Override
    public Business updateBusinessById(Long businessId, Business business) {
        BusinessEntity businessEntity = businessEntityMapper.toEntity(business);
        businessEntity.setId(businessId);
        BusinessEntity updatedBusinessEntity = businessRepository.save(businessEntity);

        return businessEntityMapper.toDomainObj(updatedBusinessEntity);
    }

    @Override
    public List<Business> getAllBusiness() {
        List<BusinessEntity> businessEntities = businessRepository.findAll();
        return businessEntityMapper.toDomainObjList(businessEntities);
    }

    @Override
    public List<Business> findByNameContainingIgnoreCase(String name) {
        List<BusinessEntity> businessEntities = businessRepository.findByNameContainingIgnoreCase(name);
        return businessEntityMapper.toDomainObjList(businessEntities);
    }
}

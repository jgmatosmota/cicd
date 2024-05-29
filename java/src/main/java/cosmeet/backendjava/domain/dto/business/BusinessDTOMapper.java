package cosmeet.backendjava.domain.dto.business;

import cosmeet.backendjava.domain.dto.user.CreateUserRequest;
import cosmeet.backendjava.domain.dto.user.CreateUserResponse;
import cosmeet.backendjava.domain.entity.Business;
import cosmeet.backendjava.domain.entity.User;

public class BusinessDTOMapper {

    public Business toBusiness(CreateBusinessRequest request) {
        return new Business(
                null,
                request.name(),
                request.email(),
                request.phone(),
                request.cnpj(),
                request.occupation(),
                request.about(),
                request.photo(),
                request.user(),
                request.plans()
        );
    }

    public Business toBusiness(GetBusinessRequest request) {
        return new Business(
                request.id(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Business toBusiness(UpdateBusinessRequest request) {
        return new Business(
                request.business().getId(),
                request.business().getName(),
                request.business().getEmail(),
                request.business().getPhone(),
                request.business().getCnpj(),
                request.business().getOccupation(),
                request.business().getAbout(),
                request.business().getPhoto(),
                request.business().getUser(),
                request.business().getPlans()
        );
    }

    public CreateBusinessResponse toCreateResponse(Business business) {
        return new CreateBusinessResponse(
                business.getId(),
                business.getName(),
                business.getEmail(),
                business.getPhoto(),
                business.getOccupation(),
                business.getAbout(),
                business.getPhone()
        );
    }

    public GetBusinessResponse toGetResponse(Business business) {
        return new GetBusinessResponse(
                business.getId(),
                business.getName(),
                business.getEmail(),
                business.getPhone(),
                business.getCnpj(),
                business.getOccupation(),
                business.getAbout(),
                business.getPhoto()
        );
    }

    public GetAllBusinessResponse toGetAllResponse(Business business) {
        return new GetAllBusinessResponse(

        );
    }

    public UpdateBusinessResponse toUpdateResponse(Business business) {
        return new UpdateBusinessResponse(
                business.getId(),
                business.getName(),
                business.getEmail(),
                business.getPhone(),
                business.getCnpj(),
                business.getOccupation(),
                business.getAbout(),
                business.getPhoto()
        );
    }


}

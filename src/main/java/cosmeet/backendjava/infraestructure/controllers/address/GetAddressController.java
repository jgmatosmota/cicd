package cosmeet.backendjava.infraestructure.controllers.address;

import cosmeet.backendjava.application.usecases.address.GetAddressInterface;
import cosmeet.backendjava.config.CepAbertoConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class GetAddressController {
    private final GetAddressInterface getAddressInterface;

    public GetAddressController(GetAddressInterface getAddressInterface) {
        this.getAddressInterface = getAddressInterface;
    }

    @GetMapping
    public ResponseEntity<CepAbertoConfig.Cep> getAddressByCep(@RequestParam("cep") String cep) {
        try {
            Optional<CepAbertoConfig.Cep> addressOptional = getAddressInterface.getAddressByCep(cep);
            if (addressOptional.isPresent()) {
                return ResponseEntity.ok(addressOptional.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            System.err.println("Falha ao processar a solicitação para o CEP: " + cep);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

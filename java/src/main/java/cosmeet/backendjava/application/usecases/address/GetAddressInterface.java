package cosmeet.backendjava.application.usecases.address;

import cosmeet.backendjava.config.CepAbertoConfig;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAddressInterface {
    private final CepAbertoConfig cepAberto;

    public GetAddressInterface(CepAbertoConfig cepAberto) {
        this.cepAberto = cepAberto;
    }

    public Optional<CepAbertoConfig.Cep> getAddressByCep(String cep) {
        if (!isValidCep(cep)) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }

        try {
            return cepAberto.searchByCep(cep);
        } catch (Exception e) {
            System.err.println("Falha ao buscar endereço para o CEP: " + cep);
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private boolean isValidCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }
}

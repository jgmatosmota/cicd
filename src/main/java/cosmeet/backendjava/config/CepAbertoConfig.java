package cosmeet.backendjava.config;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CepAbertoConfig {
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Gson gson = new Gson();

    @Value("${cepaberto.api.base-url}")
    private String baseUrl;

    @Value("${cepaberto.api.token}")
    private String apiToken;

    public Optional<Cep> searchByCep(@NonNull String cep) {
        return cepFromRequest(new Request.Builder()
                .url(String.format("%s/cep?cep=%s", baseUrl, cep))
                .addHeader("Authorization", "Token token=" + apiToken)
                .build()
        );
    }

    public Optional<Cep> searchByAddress(
            @NonNull String estado,
            @NonNull String cidade,
            String logradouro
    ) {
        return cepFromRequest(
                new Request.Builder()
                        .url(String.format("%s/address?estado=%s&cidade=%s&logradouro=%s", baseUrl, estado, cidade, logradouro))
                        .addHeader("Authorization", "Token token=" + apiToken)
                        .build()
        );
    }

    public Optional<Cep> cepFromRequest(Request request) {
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return Optional.of(gson.fromJson(response.body().string(), Cep.class));
            }
            return Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Getter
    @Setter
    public static class Cep {
        private String cep;
        private double altitude;
        private double latitude;
        private double longitude;
        private String bairro;
        private String logradouro;
        private Cidade cidade;
        private Estado estado;
    }

    @Getter
    @Setter
    public static class Cidade {
        private String nome;
        private Integer ddd;
        private String ibge;
    }

    @Getter
    @Setter
    public static class Estado {
        private String sigla;
    }

}
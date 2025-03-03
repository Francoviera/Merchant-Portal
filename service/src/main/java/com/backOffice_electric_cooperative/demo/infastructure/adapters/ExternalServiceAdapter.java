package com.backOffice_electric_cooperative.demo.infastructure.adapters;

import com.backOffice_electric_cooperative.demo.domain.models.AdditionalClientInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    //https://jsonplacceholder.typicode.com/todos/
    //

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalClientInfo getAdditionalClientInfo(Long clientId) {
        /*String apiUrl= "https://jsonplacceholder.typicode.com/users/"+clientId;
        ResponseEntity<JsonPlaceHolderClient> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderClient.class);
        JsonPlaceHolderClient client= response.getBody();

        if(client == null){
            return null;
        }
        return new AdditionalClientInfo(client.getId(), client.getName(), client.getEmail());
           */
        return null;
    }

    private static class JsonPlaceHolderClient{
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

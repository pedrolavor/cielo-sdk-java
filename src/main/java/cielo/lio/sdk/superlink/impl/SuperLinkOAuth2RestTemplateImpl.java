package cielo.lio.sdk.superlink.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import cielo.lio.sdk.superlink.Environment;
import cielo.lio.sdk.superlink.SuperLink;
import cielo.lio.sdk.superlink.model.Product;

public class SuperLinkOAuth2RestTemplateImpl implements SuperLink {

    private OAuth2RestTemplate restTemplate;
    private String url;

    public SuperLinkOAuth2RestTemplateImpl(ClientCredentialsResourceDetails resourceDetails) {
        this(resourceDetails, Environment.PRODUCTION);
    }

    public SuperLinkOAuth2RestTemplateImpl(ClientCredentialsResourceDetails resourceDetails, Environment environment) {
        this.url = environment.getResourceUrl();
        this.restTemplate = new OAuth2RestTemplate(resourceDetails);
    }

    public SuperLinkOAuth2RestTemplateImpl(String clientId, String clientSecret) {
        this(clientId, clientSecret, Environment.PRODUCTION);
    }

    public SuperLinkOAuth2RestTemplateImpl(String clientId, String clientSecret, Environment environment) {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri(environment.getAccessTokenUrl() + "/token");
        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);

        this.restTemplate = new OAuth2RestTemplate(resourceDetails);
        this.url = environment.getResourceUrl();
    }

    public Product createLink(Product product) {
        restTemplate.getAccessToken();
        ResponseEntity<Product> response = restTemplate.postForEntity(url + "/products/", product, Product.class);
        return response.getBody();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getLinks() {
        List<Product> aux = new ArrayList<Product>();
        
        restTemplate.getAccessToken();
        ResponseEntity<List<Product>> response =
            restTemplate.getForEntity(url + "/products/", (Class<List<Product>>) aux.getClass());
        return response.getBody();
    }

    public Product getLink(String id) {
        restTemplate.getAccessToken();
        ResponseEntity<Product> response = restTemplate.getForEntity(url + "/products/" + id, Product.class);
        return response.getBody();
    }

    public void updateLink(String id, Product product) {
        restTemplate.getAccessToken();
        restTemplate.put(url + "/products/" + id, product);
    }

    public void deleteLink(String id) {
        restTemplate.getAccessToken();
        restTemplate.delete(url + "/products/" + id);
    }

}
package cielo.sdk.superlink.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import cielo.sdk.superlink.Environment;
import cielo.sdk.superlink.SuperLink;
import cielo.sdk.superlink.model.PageProduct;
import cielo.sdk.superlink.model.Product;
import cielo.sdk.superlink.model.ProductFilter;

public class SuperLinkOAuth2RestTemplateImpl implements SuperLink {

    private OAuth2RestTemplate restTemplate;
    private String url;

    public SuperLinkOAuth2RestTemplateImpl(OAuth2RestTemplate restTemplate) {
        this(restTemplate, cielo.sdk.superlink.model.Environment.PRODUCTION);
    }

    public SuperLinkOAuth2RestTemplateImpl(OAuth2RestTemplate restTemplate, Environment environment) {
        if(!(restTemplate.getResource() instanceof ClientCredentialsResourceDetails)) {
            throw new IllegalArgumentException("The Resource Details must be ClientCredentialsResourceDetails");
        }

        this.restTemplate = restTemplate;
        this.url = environment.getResourceUrl();
    }

    public Product createLink(Product product) {
        restTemplate.getAccessToken();
        ResponseEntity<Product> response = restTemplate.postForEntity(url + "/products", product, Product.class);
        return response.getBody();
    }

    public PageProduct getLinks(ProductFilter filter) {
        restTemplate.getAccessToken();
        ResponseEntity<PageProduct> response = restTemplate.getForEntity(url + "/products", PageProduct.class, filter);
        return response.getBody();
    }

    public PageProduct getLinks() {
        return getLinks(null);
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
package cielo.lio.sdk.superlink;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class SuperLink {

  private OAuth2RestTemplate restTemplate;
  private Environment environment;

  public SuperLink(String clientId, String clientSecret) { 
    this.environment = Environment.PRODUCTION;

		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setAccessTokenUri(this.environment.getAccessTokenUrl() + "/token");
		resourceDetails.setClientId(clientId);
		resourceDetails.setClientSecret(clientSecret);
    
    this.restTemplate = new OAuth2RestTemplate(resourceDetails);
  }

  public SuperLink(String clientId, String clientSecret, Environment environment) { 
    this.environment = environment;
    
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setAccessTokenUri(this.environment.getAccessTokenUrl() + "/token");
		resourceDetails.setClientId(clientId);
		resourceDetails.setClientSecret(clientSecret);
    
    this.restTemplate = new OAuth2RestTemplate(resourceDetails);
  }

  public Product createLink(Product product) {
    // pegar access token
    restTemplate.getAccessToken();

    String url = environment.getResourceUrl();
    ResponseEntity<Product> response =
      restTemplate.postForEntity(url + "/products/", product, Product.class);

    return response.getBody();
  }

  public Product getLink(String id) {
    // pegar access token
    restTemplate.getAccessToken();

    String url = environment.getResourceUrl();
    ResponseEntity<Product> response =
      restTemplate.getForEntity(url + "/products/" + id, Product.class);

    return response.getBody();
  }

  public void updateLink(String id, Product product) {
    // pegar access token
    restTemplate.getAccessToken();

    String url = environment.getResourceUrl();
    restTemplate.put(url + "/products/" + id, product);
  }

  public void deleteLink(String id) {
    // pegar access token
    restTemplate.getAccessToken();

    String url = environment.getResourceUrl();
    restTemplate.delete(url + "/products/" + id);
  }
  
}
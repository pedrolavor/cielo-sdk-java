package cielo.lio.sdk.superlink;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import cielo.lio.sdk.superlink.Product.Type;

public class SuperLink {

  private OAuth2RestTemplate restTemplate;
  private cielo.lio.sdk.Environment environment;

  public SuperLink() { 
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setAccessTokenUri("http://localhost:8081/oauth/token");
		resourceDetails.setClientId("jafoi-dev");
		resourceDetails.setClientSecret("jafoi-development-cs-1027");
    
    this.restTemplate = new OAuth2RestTemplate(resourceDetails);
    
    this.environment = Environment.PRODUCTION;
  }

  public Product createLink(Product product) {
    // pegar access token
    restTemplate.getAccessToken();

    String url = environment.getUrl();
    ResponseEntity<Product> response =
      restTemplate.postForEntity(url + "/products/", product, Product.class);

    return response.getBody();
  }
  
}
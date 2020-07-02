package cielo.sdk.superlink.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import cielo.sdk.superlink.SuperLink;
import cielo.sdk.superlink.model.Environment;
import cielo.sdk.superlink.model.Product;

public class SuperLinkOAuth2RestTemplateImplTest {

    OAuth2RestTemplate restTemplate;

    SuperLink superLink;

    @Before
    public void init() {
        restTemplate = Mockito.mock(OAuth2RestTemplate.class);
        Mockito.when(restTemplate.getResource()).thenReturn(new ClientCredentialsResourceDetails());
        superLink = new SuperLinkOAuth2RestTemplateImpl(restTemplate);
    }

    @Test
    public void whenCreteNewSuperLink_ThenReturnSuccessfuly() {
        OAuth2RestTemplate restTemplate =
            new OAuth2RestTemplate(new ClientCredentialsResourceDetails());

        SuperLink superLink1 = new SuperLinkOAuth2RestTemplateImpl(restTemplate);
        SuperLink superLink2 = new SuperLinkOAuth2RestTemplateImpl(restTemplate, Environment.PRODUCTION);

        assertNotNull(superLink1);
        assertNotNull(superLink2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenResourceDetailsNotClientCredentials_ThenThrowException() {
        OAuth2RestTemplate restTemplate =
            new OAuth2RestTemplate(new BaseOAuth2ProtectedResourceDetails());

        new SuperLinkOAuth2RestTemplateImpl(restTemplate);
    }

    @Test
    public void whenRequestedCreateProduct_ThenReturnProductCreated() {

        Product product = Product.builder()
            .id("1")
            .name("Product Name")
            .price(2000)
            .build();

        ResponseEntity<Product> response = ResponseEntity.ok(product);
        Mockito.when(restTemplate.postForEntity(
            Mockito.anyString(), Mockito.any(), Mockito.eq(Product.class)))
            .thenReturn(response);

        Product createdProduct = superLink.createLink(product);

        assertNotNull("Should return created product", createdProduct);
        assertEquals("Create product should be equals passed product", product, createdProduct);
    }

    @Test
    public void whenRequestedGetProduct_ThenReturnProduct() {

        Product product = Product.builder()
            .id("1")
            .name("Product Name")
            .price(2000)
            .build();

        ResponseEntity<Product> response = ResponseEntity.ok(product);
        Mockito.when(restTemplate.getForEntity(
            Mockito.anyString(), Mockito.eq(Product.class)))
            .thenReturn(response);

        Product createdProduct = superLink.getLink("1");

        assertNotNull("Should return created product", createdProduct);
        assertEquals("Create product should be equals passed product", product, createdProduct);
    }
    
}
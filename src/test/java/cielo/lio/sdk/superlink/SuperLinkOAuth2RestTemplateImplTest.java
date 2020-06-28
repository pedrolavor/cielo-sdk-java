package cielo.lio.sdk.superlink;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import cielo.lio.sdk.superlink.impl.SuperLinkOAuth2RestTemplateImpl;

public class SuperLinkOAuth2RestTemplateImplTest {

    @Test
    public void whenCreteNewSuperLink_ThenReturnSuccessfuly() {

        SuperLink superLink1 = new SuperLinkOAuth2RestTemplateImpl("clientId", "clientSecret", Environment.SANDBOX);
        SuperLink superLink2 = new SuperLinkOAuth2RestTemplateImpl("clientId", "clientSecret");
        SuperLink superLink3 = new SuperLinkOAuth2RestTemplateImpl(
            new ClientCredentialsResourceDetails(), Environment.SANDBOX);
        SuperLink superLink4 = new SuperLinkOAuth2RestTemplateImpl(
            new ClientCredentialsResourceDetails());

        assertNotNull(superLink1); 
        assertNotNull(superLink2);
        assertNotNull(superLink3);
        assertNotNull(superLink4);

    }
    
}
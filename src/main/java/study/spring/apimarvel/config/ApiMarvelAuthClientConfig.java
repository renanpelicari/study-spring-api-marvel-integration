package study.spring.apimarvel.config;

import com.ciandt.commons.security.config.OAuth2FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class ApiMarvelAuthClientConfig {

    //FIXME - not use accessTokenUri, clientId and Secret should use as public key and hash as pathParam
    // refer: https://developer.marvel.com/documentation/authorization)

    @Value("${security.oauth2.client.accessTokenUri}")
    protected String accessTokenUri;

    @Value("${security.oauth2.client.clientId}")
    protected String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    protected String clientSecret;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(oAuth2ClientContext(), oAuth2ProtectedResourceDetails());
    }

    @Bean
    public OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
        final ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri(accessTokenUri);
        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);
        return resourceDetails;
    }

    public OAuth2ClientContext oAuth2ClientContext() {
        return new DefaultOAuth2ClientContext();
    }
}

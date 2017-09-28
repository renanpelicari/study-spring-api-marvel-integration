package study.spring.apimarvel.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import study.spring.apimarvel.config.ApiMarvelAuthClientConfig;

/**
 * REST interface for Integration with Marvel API
 */
@FeignClient(value = "marvel-api", configuration = ApiMarvelAuthClientConfig.class)
public interface ApiMarvelIntegrationClient {
}

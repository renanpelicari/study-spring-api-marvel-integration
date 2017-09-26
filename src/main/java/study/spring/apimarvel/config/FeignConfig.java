package study.spring.apimarvel.config;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * Spring Configurations for Feign
 */
@Slf4j
@Configuration
public class FeignConfig {

    /**
     * The feign {@link ErrorDecoder} config.
     *
     * @return the {@link ErrorDecoder} bean
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            final String errorMessage = "Error on execute remote call " + methodKey;
            final String body = parseFeignBody(response);
            log.error("Error on execute remote call {}\nResponse status: {}\nResponse body:\n {}",
                methodKey, response.status(), body);
            final HttpStatus status = HttpStatus.valueOf(response.status());
            if (status.is4xxClientError()) {
                return new HystrixBadRequestException(errorMessage);
            }
            return new HystrixBadRequestException(errorMessage);
        };
    }

    private static String parseFeignBody(final Response response) {
        if (response.body() != null) {
            try {
                return Util.toString(response.body().asReader());
            } catch (final IOException e) {
                log.error("Error to parse response body", e);
            }
        }
        return null;
    }
}

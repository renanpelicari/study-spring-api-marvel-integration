package study.spring.apimarvel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("STUDY-SPRING-API-MARVEL")
            .apiInfo(metadata())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(regex("/api/.*"))
            .build()
            .pathMapping("/")
            .apiInfo(metadata());
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
            .title("Study Spring API with Marvel Integration")
            .description("API for study purpose. Connect to Marvel API and handle internal.")
            .version("1.0")
            .contact("renanpelicari@gmail.com")
            .build();
    }
}

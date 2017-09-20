package study.spring.apimarvel.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Hello End point Controller.
 */
@RestController
@RequestMapping(value = "/api/test/hello")
@Api(value = "/api/test/hello")
@Slf4j
public class HelloController {

    @GetMapping
    @ApiOperation(value = "Hello world!", nickname = "helloWorld")
    public final String getHelloWorld() {
        return "Hello World!\n" +
            "Welcome to Spring Boot Study with Marvel API";
    }
}

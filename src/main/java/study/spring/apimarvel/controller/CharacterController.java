package study.spring.apimarvel.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Character controller endpoint.
 */
@Slf4j
@RestController
@Api(value = "/api/character")
@RequestMapping(value = "/api/character")
public class CharacterController {

}

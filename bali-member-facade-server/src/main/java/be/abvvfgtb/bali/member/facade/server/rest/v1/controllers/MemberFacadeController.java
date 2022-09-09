package be.abvvfgtb.bali.member.facade.server.rest.v1.controllers;


import be.abvvfgtb.bali.domain.BaliResultDto;
import be.abvvfgtb.bali.domain.MessageResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class MemberFacadeController implements IMemberFacadeController {

    @Value("${server.url.member}")
    private String memberUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/memberFacade")
    public ResponseEntity<BaliResultDto> getMember(@RequestParam(value = "name", defaultValue = "World") String name, HttpServletRequest request) {
        HttpHeaders headers = IMemberFacadeController.createHeaders("admin", "admin");
        headers.set("name", name);

        String body = restTemplate().exchange(memberUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody();

        return ResponseEntity.ok(new BaliResultDto()
                .messageResponse(new MessageResponseDto()
                        .message(String.format("Hello %s from Member Facade Server: '%s'", name, body))));

    }

}
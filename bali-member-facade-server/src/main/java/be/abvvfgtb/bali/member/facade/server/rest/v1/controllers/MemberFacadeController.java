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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<BaliResultDto> getMember(@RequestParam(value = "firstName") String firstName,
                                                   @RequestParam(value = "lastName") String lastName,
                                                   HttpServletRequest request) {
        HttpHeaders headers = IMemberFacadeController.createHeaders("admin", "admin");
        headers.set("firstName", firstName);
        headers.set("lastName", lastName);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(memberUrl)
                .queryParam("firstName",firstName)
                .queryParam("lastName",lastName)
                .build();

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> body = restTemplate().exchange(builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class);


        return ResponseEntity.ok(new BaliResultDto()
                .messageResponse(new MessageResponseDto()
                        .message(String.format("Hello %s %s from Member Facade Server: '%s'", firstName, lastName, body.getBody()))));

    }

}
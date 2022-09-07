package be.abvvfgtb.bali.member.server.rest.v1.controllers;


import be.abvvfgtb.bali.domain.BaliResultDto;
import be.abvvfgtb.bali.domain.MessageResponseDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;

@RequestMapping("/v1")
@RestController
public class MemberFacadeController implements IMemberFacadeController{

    @Value("${server.url.member}")
    private String memberUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/memberFacade")
    public ResponseEntity<BaliResultDto> getMember(@RequestParam(value = "name", defaultValue = "World") String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(IMemberFacadeController.createHeaders("admin", "admin"));
        System.out.println(memberUrl);

        String body = restTemplate().exchange(memberUrl, HttpMethod.GET, entity, String.class).getBody();
        String format = String.format("Hello from Member Facade: '" + body + "'");
        MessageResponseDto mr = new MessageResponseDto();
        mr.setMessage(format);
        BaliResultDto br = new BaliResultDto();
        br.setMessageResponse(mr);
        return ResponseEntity.ok(br);

    }



}
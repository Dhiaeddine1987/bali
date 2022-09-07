package be.abvvfgtb.bali.member.server.rest.v1.controllers;

import be.abvvfgtb.bali.domain.BaliResultDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.Charset;

public interface IMemberFacadeController {

    ResponseEntity<BaliResultDto> getMember(@RequestParam(value = "name", defaultValue = "World") String name);

    static HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }


}
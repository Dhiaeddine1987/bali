package be.abvvfgtb.bali.member.server.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class MemberController implements IMemberController{

    @GetMapping("/member")
    public String getMember(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi %s from Member Server!", name);
    }
}
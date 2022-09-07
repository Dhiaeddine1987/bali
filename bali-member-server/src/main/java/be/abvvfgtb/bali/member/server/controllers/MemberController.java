package be.abvvfgtb.bali.member.server.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class MemberController {

    @GetMapping("/member")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi %s from Member Server!", name);
    }
}
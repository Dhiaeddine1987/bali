package bali.member.server.controllers;


import bali.member.server.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/v1")
@RestController
public class MemberController {

    @GetMapping("/memrber")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi %s from Member Server!", name);
    }
}
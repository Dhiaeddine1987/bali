package be.abvvfgtb.bali.member.server.controllers;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class MemberController implements IMemberController {

    @GetMapping("/member")
    public String getMember(@RequestParam(value = "name", defaultValue = "World") String name, HttpServletRequest request) {
        return String.format("Hi %s from Member Server!", request.getHeader("name"));
    }
}
package be.abvvfgtb.bali.member.server.controllers;


import be.abvvfgtb.bali.member.server.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class MemberController implements IMemberController {


    @Autowired
    private IMemberService memberService;

    @GetMapping("/member")
    public String getMember(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, HttpServletRequest request) {
//        String firstName = request.getHeader("firstName");
//        String lastName = request.getHeader("lastName");
        return String.format("Hi %s %s from Member Server! Your phone number is: %s", firstName, lastName, memberService.getMember(firstName, lastName));
    }
}
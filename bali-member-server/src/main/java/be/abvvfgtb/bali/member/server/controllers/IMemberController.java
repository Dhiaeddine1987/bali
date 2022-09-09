package be.abvvfgtb.bali.member.server.controllers;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface IMemberController {

    String getMember(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, HttpServletRequest request);

}

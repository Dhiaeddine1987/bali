package be.abvvfgtb.bali.member.server.controllers;

import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberController {

    String getMember(@RequestParam(value = "name", defaultValue = "World") String name);
}

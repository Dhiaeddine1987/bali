package be.abvvfgtb.janus.congres.server;

import be.abvvfgtb.janus.congres.server.rest.v1.controllers.MemberController;
import org.springframework.boot.SpringApplication;

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(MemberController.class, args);
    }
}

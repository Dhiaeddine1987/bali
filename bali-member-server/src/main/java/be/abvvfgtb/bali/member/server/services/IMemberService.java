package be.abvvfgtb.bali.member.server.services;

import org.springframework.stereotype.Service;

@Service
public interface IMemberService {

    public String getMember(String firstName, String lastName);

}

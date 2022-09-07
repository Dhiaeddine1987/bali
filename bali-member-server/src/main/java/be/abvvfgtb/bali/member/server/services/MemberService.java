package be.abvvfgtb.bali.member.server.services;

import org.springframework.stereotype.Service;


@Service
public class MemberService implements IMemberService{

    public String getMember(String firstName) {
        return firstName;
    }
}

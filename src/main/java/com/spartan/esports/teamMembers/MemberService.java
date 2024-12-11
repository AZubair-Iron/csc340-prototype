package com.spartan.esports.teamMembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRespository memberRespository;

    public List<Member> getAllMembers() {
        return memberRespository.findAll();
    }

    public Member getMemberById(int memberId) {
        return memberRespository.findById(memberId).orElse(null);
    }

    public List<Member> getMemberByRole(String role) {
        return memberRespository.findByRole(role);
    }

    public void addNewMember(Member member) {
        memberRespository.save(member);
    }

    public void updateMember(int member) {
        Member existing = getMemberById(member);
        existing.setTag(existing.getTag());
        existing.setRole(existing.getRole());
        existing.setUser(existing.getUser());
        existing.setTeam(existing.getTeam());

        memberRespository.save(existing);
    }

    public void updateTag(int memberId, String newTag) {
        Member existing = getMemberById(memberId);

        existing.setTag(newTag);

        memberRespository.save(existing);
    }

    public void deleteMemberById(int memberId) {
        memberRespository.deleteById(memberId);
    }

}

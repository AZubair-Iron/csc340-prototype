package com.example.demo.teamMembers;

import com.example.demo.teams.Team;
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

    public Member getMemberByTeam(Team teamId) {
        return (Member) memberRespository.findByTeam(teamId);
    }

    public List<Member> getMemberByRole(String role) {
        return memberRespository.findByRole(role);
    }

    public void addNewMember(Member member) {
        memberRespository.save(member);
    }

    public void updateMember(int memberId, Member member) {
        Member existing = getMemberById(memberId);
        existing.setRole(member.getRole());
        existing.setTeam(member.getTeam());

        memberRespository.save(existing);
    }

    public void saveMember(Member member) {
        memberRespository.save(member);
    }

    public void deleteMemberById(int memberId) {
        memberRespository.deleteById(memberId);
    }

}
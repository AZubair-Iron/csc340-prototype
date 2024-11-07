package com.spartan.esports.teamMembers;
import com.spartan.esports.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/all")
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }

    @GetMapping("/{memberId}")
    public Member GetMemberById(@PathVariable int memberId) {
        return service.getMemberById(memberId);
    }

    @GetMapping("/role")
    public List<Member> getMemberByRole(@RequestParam(name = "role", defaultValue = "Player") String role) {
        return service.getMemberByRole(role);
    }

    @PostMapping("/new")
    public List<Member> addNewMember(@RequestBody Member member) {
        service.addNewMember(member);
        return service.getAllMembers();
    }

    @PutMapping("/update/{memberId}")
    public Member updateMember(@PathVariable int memberId, @RequestBody Member member) {
        service.updateMember(memberId, member);
        return service.getMemberById(memberId);
    }

    @DeleteMapping("/delete/{memberId}")
    public List<Member> deleteMemberById(@PathVariable int memberId) {
        service.deleteMemberById(memberId);
        return service.getAllMembers();
    }
}

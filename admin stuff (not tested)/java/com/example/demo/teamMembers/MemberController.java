package com.example.demo.teamMembers;

import com.example.demo.teams.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/all")
    public String getAllMembers(Model model) {
        model.addAttribute("memberList", service.getAllMembers());
        return "manage-edit-team";
    }

    @GetMapping("/{memberId}")
    public Member GetMemberById(@PathVariable int memberId) {
        return service.getMemberById(memberId);
    }

    @GetMapping("/role")
    public List<Member> getMemberByRole(@RequestParam(name = "role", defaultValue = "Player") String role) {
        return service.getMemberByRole(role);
    }

    @GetMapping("/newMemberForm")
    public String showNewMemberForm() {
        return "new-member";
    }

    @PostMapping("/new")
    public String addNewMember(@RequestBody Member member) {
        service.addNewMember(member);
        return "redirect:/members/all";
    }

    @GetMapping("/team")
    public String getTeamMembers(@RequestParam(name = "team") Team team, Model model) {
        model.addAttribute("memberList", service.getMemberByTeam(team));
        return "manage-edit-team";
    }

    @PutMapping("/update/{memberId}")
    public Member updateMember(@PathVariable int memberId, @RequestBody Member member) {
        service.updateMember(memberId, member);
        return service.getMemberById(memberId);
    }

    @GetMapping("/delete/{memberId}")
    public String deleteMemberById(@PathVariable int memberId) {
        service.deleteMemberById(memberId);
        return "redirect:/members/all";
    }
}
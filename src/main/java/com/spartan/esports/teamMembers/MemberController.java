package com.spartan.esports.teamMembers;
import com.spartan.esports.games.Game;
import com.spartan.esports.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @Autowired
    private TeamService teamService;


    /**
     * Get a list of all Members in the database.
     * http://localhost:8080/members/all
     *
     * @return a list of Members  objects.
     */
    @GetMapping("/all")
    //public List<Member> getAllMembers()  return service.getAllMembers(); }
    public String getAllMembers(Model model) {

        model.addAttribute("memberList",service.getAllMembers());
        model.addAttribute("title", "All Members");
        return "/games/teamMembers";
    }


    /**
     * Get a specific Member by Id.
     * http://localhost:8080/members/{gameId}/{teamId}
     *
     * @param teamId the unique Id for a Member.
     * @return One Member object.
     */
    @GetMapping("/{teamId}")
    public String getMemberByTeam(@PathVariable int teamId, Model model) {

        List<Member> members = service.getAllMembers();

        // Filter members by teamId
        members.removeIf(m -> m.getTeam().getTeamId() != teamId);

        // Create separate lists for each role, ensuring they don't share references
        List<Member> Coach = members.stream()
                .filter(m -> "Coach".equals(m.getRole())) // Ensure exact role name match
                .collect(Collectors.toList());

        List<Member> Manager = members.stream()
                .filter(m -> "Manager".equals(m.getRole()))
                .collect(Collectors.toList());

        List<Member> Player = members.stream()
                .filter(m -> "Player".equals(m.getRole()))
                .collect(Collectors.toList());

        List<Member> Sub = members.stream()
                .filter(m -> "Sub".equals(m.getRole()))
                .collect(Collectors.toList());

// Add attributes to model
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("coachList", Coach);
        model.addAttribute("managerList", Manager);
        model.addAttribute("playerList", Player);
        model.addAttribute("subList", Sub);

        return "/games/teamMembers";
    }


    /**
     * Get a list of Members based on their species.
     * http://localhost:8080/members/name?member="Valorant"
     *
     * @param member the search key.
     * @return A list of Member objects matching the search key.
     */
  //  @GetMapping("/name")
  //  public List<Member> getMembersByName(@RequestParam(name = "member", defaultValue = "Valorant") String member) {
   //     return service.getMemberByName(member);
   // }

    /**
     * Create a new Member entry.
     * http://localhost:8080/members/new --data '{"name": "sample4", "science_name": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param member the new Member object.
     * @return the updated list of Members.
     */
    @PostMapping("/new")
    public String addNewMember(Member member) {
        service.addNewMember(member);
        return "redirect:/members/all";
    }

    @PostMapping("/add")
    public String addMember(@RequestParam String member, @RequestParam Game game) {
        Member newMember = new Member();
       // newMember.setName(member);
       // newMember.setGame(game);
        service.addNewMember(newMember);
        return "redirect:/members/all"; // Redirect back to the members list page after saving
    }



    /**
     * Update an existing Member object.getMembersByHabitat
     * http://localhost:8080/members/update/2 --data '{"name": "sample4", "scienceName": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param memberId the unique Member Id.
     * @param model
     * @return the updated Member object.
     */
    @GetMapping("/update/{memberId}")
    public String showUpdateFrom(@PathVariable int memberId, Model model) {
        model.addAttribute("member", service.getMemberById(memberId));
        return "/games/memberUpdate";
    }

    @PostMapping("/update/finish/{memberId}")
    public String updateMember(@PathVariable int memberId, Member member) {
        service.updateMember(memberId);
        return "redirect:/members/" + member.getTeam().getTeamId();
    }


    @PostMapping("/update-tag")
    public String updateMemberTag(@RequestParam("member_id") int memberId, @RequestParam("tag") String tag) {
        service.updateTag(memberId, tag);
        return "redirect:/members/" + service.getMemberById(memberId).getTeam().getTeamId();
    }

    /**
     * Delete a Member object.
     * http://localhost:8080/members/delete/2
     *
     * @param memberId the unique Member Id.
     * @return the updated list of Member.
     */
    @GetMapping("/delete/{memberId}")
    public String deleteMemberById(@PathVariable int memberId) {
        service.deleteMemberById(memberId);
        return "redirect:/members/all";
    }
}

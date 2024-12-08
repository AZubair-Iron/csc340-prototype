package com.example.demo.bans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/banlist")
public class BanListController {

    @Autowired
    private BanListService banListService;

    @GetMapping("/all")
    public String getAllBanList(Model model) {
        model.addAttribute("banList", banListService.getAllBanList());
        return "banreports";
    }
/**
 @GetMapping("/{user_id}")
 public BanList getOneBanList(@PathVariable int user_id) {
 return banListService.getBanListByID(user_id);
 }

 @GetMapping("/name")
 public List<BanList> getBanListByName(@RequestParam(name = "user_name", defaultValue = "Eater") String user_name) {
 return banListService.getBanListByUsername(user_name);
 }
*/
    @GetMapping("/newBanForm")
    public String showNewBanForm() {
        return "new-ban-form";
    }

     @PostMapping("/new")
     public String addNewBanList(@RequestBody BanList banList) {
         banListService.addNewBanList(banList);
         return "redirect:/banlist/all";
     }


    @GetMapping("/update/{user_id}")
    public String showBanListUpdateForm(@PathVariable int user_id, Model model) {
        model.addAttribute("banned_list", banListService.getBanListByID(user_id));
        return "banreports-update";
    }

     @PostMapping("/update")
     public String updateBanList(BanList banlist) {
         banListService.addNewBanList(banlist);
         return "redirect:/banlist/all";
     }



     @GetMapping("/delete/{user_id}")
     public String deleteBanListByID(@PathVariable int user_id) {
         banListService.deleteBanListByID(user_id);
         return "redirect:banlist/all";
     }

}

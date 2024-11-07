package com.example.demo.ban;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banlist")
public class BanListController {

    @Autowired
    private BanListService banListService;

    @GetMapping("/all")
    public List<BanList> getAllBanList() {
        return banListService.getAllBanList();
    }

    @GetMapping("/{user_id}")
    public BanList getOneBanList(@PathVariable int user_id) {
        return banListService.getBanListByID(user_id);
    }

    @GetMapping("/name")
    public List<BanList> getBanListByName(@RequestParam(name = "user_name", defaultValue = "Eater") String user_name) {
        return banListService.getBanListByUsername(user_name);
    }

    @PostMapping("/new")
    public List<BanList> addNewBanList(@RequestBody BanList banList) {
        banListService.addNewBanList(banList);
        return banListService.getAllBanList();
    }

    @PutMapping("/update/{user_id}")
    public BanList updateBanList(@PathVariable int user_id, @RequestBody BanList banlist) {
        banListService.updateBanList(user_id, banlist);
        return banListService.getBanListByID(user_id);
    }

    @DeleteMapping("/delete/{user_id}")
    public List<BanList> deleteBanListByID(@PathVariable int user_id) {
        banListService.deleteBanListByID(user_id);
        return banListService.getAllBanList();
    }
}

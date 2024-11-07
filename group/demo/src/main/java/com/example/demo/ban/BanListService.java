package com.example.demo.ban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanListService {

    @Autowired
    private BanListRepository banListRepository;

    public List<BanList> getAllBanList() {return banListRepository.findAll();}

    public BanList getBanListByID(int user_id) {return banListRepository.findById(user_id).orElse(null);}

    public List<BanList> getBanListByUsername(String user_name) {return banListRepository.getBanListByUsername(user_name);}

    public void addNewBanList(BanList banList) {banListRepository.save(banList);}

    public void updateBanList(int user_id, BanList banList) {
        BanList existing = getBanListByID(user_id);

        existing.setOffense(banList.getOffense());

        banListRepository.save(existing);
    }

    public void deleteBanListByID(int user_id) {
        banListRepository.deleteById(user_id);
    }
}

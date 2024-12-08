package com.example.demo.bans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanListRepository extends JpaRepository<BanList, Integer> {

    @Query(value = "select * from banned_list where user_name like %?%", nativeQuery = true)
    List<BanList> getBanListByUsername(String user_name);
}
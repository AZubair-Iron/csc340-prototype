package com.example.demo.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query(value = "select * from reports where name like %?%", nativeQuery = true)
    List<Report> getReportByName(String name);
}

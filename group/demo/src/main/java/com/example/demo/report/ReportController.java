package com.example.demo.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public List<Report> getAllReport() {
        return reportService.getAllReport();
    }

    @GetMapping("/{id}")
    public Report getOneReport(@PathVariable int id) {
        return reportService.getReportByID(id);
    }

    @GetMapping("/name")
    public List<Report> getReportByName(@RequestParam(name = "name", defaultValue = "NooB01") String name) {
        return reportService.getReportByName(name);
    }

    @PostMapping("/new")
    public List<Report> addNewReport(@RequestBody Report report) {
        reportService.addNewReport(report);
        return reportService.getAllReport();
    }

    @PutMapping("/update/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report report) {
        reportService.updateReport(id, report);
        return reportService.getReportByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Report> deleteReportByID(@PathVariable int id) {
        reportService.deleteReportByID(id);
        return reportService.getAllReport();
    }
}

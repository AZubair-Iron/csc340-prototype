package com.example.demo.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReport() {return reportRepository.findAll();}

    public Report getReportByID(int id) {return reportRepository.findById(id).orElse(null);}

    public List<Report> getReportByName(String name) {return reportRepository.getReportByName(name);}

    public void addNewReport(Report report) {reportRepository.save(report);}

    public void updateReport(int id, Report report) {
        Report existing = getReportByID(id);

        existing.setOffense(report.getOffense());
        existing.setRecount(report.getRecount());

        reportRepository.save(existing);
    }

    public void deleteReportByID(int id) {
        reportRepository.deleteById(id);
    }
}

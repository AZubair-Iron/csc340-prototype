package com.spartan.esports.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {return applicationRepository.findAll();}

    public Application getApplicationByID(int user_id) {return applicationRepository.findById(user_id).orElse(null);}

    public List<Application> getApplicationByGame(String game) {return applicationRepository.getApplicationByGame(game);}

    public List<Application> getApplicationByCoach(String coach) {return applicationRepository.getApplicationByCoach(coach);}

    public void addNewApplication(Application application){applicationRepository.save(application);}

    public void updateApplication(int user_id, Application application) {
        Application existing = getApplicationByID(user_id);

        existing.setCoach(application.getCoach());
        existing.setGame(application.getGame());
        existing.setYear(application.getYear());
        existing.setRank(application.getRank());
        existing.setAplication(application.getAplication());

        applicationRepository.save(existing);
    }

    public void deleteApplicationByID(int user_id){
        applicationRepository.deleteById(user_id);
    }
}

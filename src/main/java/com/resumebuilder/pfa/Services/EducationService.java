package com.resumebuilder.pfa.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebuilder.pfa.Models.Education;
import com.resumebuilder.pfa.Repositories.EducationRepository;

@Service
public class EducationService {
    
    @Autowired
    private EducationRepository educationRepository;


    public void saveEducation(Education education){
        Optional<Education> existedEducation = educationRepository.findById(education.getID());
        if (!existedEducation.isPresent()) {
            educationRepository.save(education);
        }
    }
}

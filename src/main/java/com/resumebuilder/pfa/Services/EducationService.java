package com.resumebuilder.pfa.Services;

import java.util.List;
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

    public List<Education> getEducationsByUserID(Long id){
        return educationRepository.findAllByUID(id);
    }
      //Update Education
      public Education updateEducation(Education education) throws Exception{
        Optional<Education> existedEducation = educationRepository.findById(education.getID());
        if (!existedEducation.isPresent()) {
            throw new Exception("Education Not Found");
        }
        existedEducation.get().setEndDate(education.getEndDate());
        existedEducation.get().setStartDate(education.getStartDate());
        existedEducation.get().setTitle(education.getTitle());
        existedEducation.get().setUniversity(education.getUniversity());
        return educationRepository.save(existedEducation.get());
    }

    // Delete Education
    public String deleteEducation(Education education) throws Exception{
        Optional<Education> existedEducation = educationRepository.findById(education.getID());
        if (!existedEducation.isPresent()) {
            throw new Exception("Education Not Found");
        }
        educationRepository.delete(education);
        return "Education deleted with success";
    }
}

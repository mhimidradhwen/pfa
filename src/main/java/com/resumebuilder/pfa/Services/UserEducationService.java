
package com.resumebuilder.pfa.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebuilder.pfa.Models.Education;
import com.resumebuilder.pfa.Models.User;
import com.resumebuilder.pfa.Repositories.UserRepository;

@Service
public class UserEducationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EducationService educationService;

    // Add Education
    public User addEducation(Long id, Education education) throws Exception {
        Optional<User> existedUser = userRepository.findById(id);
        if (!existedUser.isPresent()) {
            throw new Exception("User Not Exist");
        }
        education.setID(UUID.randomUUID().toString().split("-").toString());
        education.setUID(id);
        existedUser.get().getEducations().add(education);
        educationService.saveEducation(education);
        return userRepository.save(existedUser.get());
    }

    // Get Education
    public List<Education> getEducations(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<Education> educations = user.get().getEducations();
            if (educations.size() == 0) {
                throw new Exception("No Educations Found");
            }
            return educations;
        }
        throw new Exception("User Not Found");
    }

}

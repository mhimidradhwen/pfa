package com.resumebuilder.pfa.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebuilder.pfa.Models.User;
import com.resumebuilder.pfa.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setID(new Random().nextLong());
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() throws Exception {
        List<User> users = userRepository.findAll();
        if (users.size() == 0) {
            throw new Exception("No Users Exists");
        }
        return users;
    }


    public User getUserById(Long ID) throws Exception {
        Optional<User> user = userRepository.findById(ID);
        if (!user.isPresent()) {
            throw new Exception("No User Exists with this ID");
        }
        return user.get();
    }

    public String deleteUserById(Long ID) throws Exception {
        Optional<User> user = userRepository.findById(ID);
        if (!user.isPresent()) {
            throw new Exception("No User Exists with this ID");
        }
        userRepository.deleteById(ID);
        return "User Deleted With Success";
    }

    public User updateUserById(User user, Long ID) throws Exception {
        Optional<User> existedUser = userRepository.findById(ID);
        if (!existedUser.isPresent()) {
            throw new Exception("No User Exists with this ID");
        }
        existedUser.get().setFirstName(user.getFirstName());
        existedUser.get().setLastName(user.getLastName());
        existedUser.get().setEmail(user.getEmail());
        return userRepository.save(existedUser.get());
    }

  
}

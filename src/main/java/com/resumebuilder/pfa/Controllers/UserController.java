package com.resumebuilder.pfa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumebuilder.pfa.Models.Education;
import com.resumebuilder.pfa.Models.User;
import com.resumebuilder.pfa.Services.UserEducationService;
import com.resumebuilder.pfa.Services.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEducationService userEducationService;

    // Register New User
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

    }

    // Get User By ID
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    // Get All Users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Add Education
    @PostMapping("/user/{id}/educations")
    public ResponseEntity<?> addEducationToUser(@PathVariable Long id, @RequestBody Education education) {
        try {
            return new ResponseEntity<User>(userEducationService.addEducation(id, education), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get User Educations
    @GetMapping("/user/{id}/educations")
    public ResponseEntity<?> getEductaionOfUserByID(@PathVariable Long id) {
        try {
            return new ResponseEntity<List<Education>>(userEducationService.getEducations(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update Education By User ID
    @PutMapping("/user/{id}/educations")
    public ResponseEntity<?> updateEducationByUserID(@PathVariable Long id, @RequestBody Education education) {
        try {
            return new ResponseEntity<User>(userEducationService.updateEducationByUserID(id, education), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update User
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
        try {
            return new ResponseEntity<User>(userService.updateUserById(user, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete User
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            return new ResponseEntity<String>(userService.deleteUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

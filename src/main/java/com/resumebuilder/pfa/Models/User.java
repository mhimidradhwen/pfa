package com.resumebuilder.pfa.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "users")
public class User {

    @Id
    private Long ID;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Address address;
    private List<Education> educations = new ArrayList<Education>();
    private List<Experience> experiences = new ArrayList<Experience>();
    private List<Skills> softSkills = new ArrayList<Skills>();
    private List<Skills> hardSkills = new ArrayList<Skills>();
    private List<Language> languages = new ArrayList<Language>();
    private List<Interests> interests = new ArrayList<Interests>();
    private Date createdAt;
}

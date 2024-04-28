package com.resumebuilder.pfa.Models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

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

    @NonNull
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date createdAt;
    private List<Education> educations;
    
}

package com.resumebuilder.pfa.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Document(collection = "educations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Education {
    @Id
    private String ID;
    
    private String title;
    private String university;
    private Date startDate;
    private Date endDate;
    private Long userID;

}

package com.resumebuilder.pfa.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Interests {
    @Id
    private String ID;
    private String title;

}

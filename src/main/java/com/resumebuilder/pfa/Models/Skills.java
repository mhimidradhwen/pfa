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
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Skills {
    @Id
    private String ID;
    private String title;

}

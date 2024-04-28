package com.resumebuilder.pfa.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    private String city;
    private String country;
    private int postalCode;
}

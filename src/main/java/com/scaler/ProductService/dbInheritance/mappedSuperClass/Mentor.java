package com.scaler.ProductService.dbInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_mentor")
public class Mentor extends User {

    private String companyName;
    private int noOfStudentMentored;

}

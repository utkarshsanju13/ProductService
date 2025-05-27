package com.scaler.ProductService.dbInheritance.tablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User {

    private String companyName;
    private int noOfStudentMentored;

}

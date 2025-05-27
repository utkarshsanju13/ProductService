package com.scaler.ProductService.dbInheritance.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {

    private Long NoOfClassTaken;
    private String subject;
    private int rating;
}

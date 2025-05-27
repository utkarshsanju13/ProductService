package com.scaler.ProductService.dbInheritance.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_instructor")
@DiscriminatorValue(value = "1")
public class Instructor extends User {

    private Long NoOfClassTaken;
    private String subject;
    private int rating;
}

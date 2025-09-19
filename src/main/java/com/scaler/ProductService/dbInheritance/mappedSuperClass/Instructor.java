package com.scaler.ProductService.dbInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_instructor")
public class Instructor extends User{

    private Long NoOfClassTaken;
    private String subject;
    private int rating;
}

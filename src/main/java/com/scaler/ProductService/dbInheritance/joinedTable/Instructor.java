package com.scaler.ProductService.dbInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {

    private Long NoOfClassTaken;
    private String subject;
    private int rating;
}

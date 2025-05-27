package com.scaler.ProductService.dbInheritance.SingleTable;

import jakarta.persistence.Entity;

public class Instructor extends User {

    private Long NoOfClassTaken;
    private String subject;
    private int rating;
}

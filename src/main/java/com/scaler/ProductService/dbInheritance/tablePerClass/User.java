package com.scaler.ProductService.dbInheritance.tablePerClass;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @Id
    private  Long id;
    private String email;
    private String name;


}

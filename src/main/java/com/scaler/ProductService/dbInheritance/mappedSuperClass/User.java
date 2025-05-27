package com.scaler.ProductService.dbInheritance.mappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {

    @Id
    private  Long id;
    private String email;
    private String name;


}

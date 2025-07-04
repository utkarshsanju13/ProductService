package com.scaler.ProductService.dbInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    private  Long id;
    private String email;
    private String name;


}

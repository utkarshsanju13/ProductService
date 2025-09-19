package com.scaler.ProductService.dbInheritance.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
        //we can declare the type as string and char also ,
        // must we declared int as it less size as string can be a larger in size
)
@DiscriminatorValue(value="0")
public class User {
    @Id
    private  Long id;
    private String email;
    private String name;


}

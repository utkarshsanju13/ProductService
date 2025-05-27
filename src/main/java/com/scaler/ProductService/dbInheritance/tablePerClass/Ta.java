package com.scaler.ProductService.dbInheritance.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="tpc_ta")
public class Ta extends User {

    private int numberOfHR;
}

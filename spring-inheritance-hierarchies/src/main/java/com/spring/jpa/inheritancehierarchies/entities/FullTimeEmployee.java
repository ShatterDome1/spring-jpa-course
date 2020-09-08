package com.spring.jpa.inheritancehierarchies.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;

@Entity
@NamedQuery(name = "retrieve_all_full_time_employees", query = "Select f from FullTimeEmployee f")
public class FullTimeEmployee extends Employee {
    private BigDecimal salary;

    public FullTimeEmployee() {}

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}

package com.spring.jpa.inheritancehierarchies.entities;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.servlet.http.Part;
import java.math.BigDecimal;

@Entity
@NamedQuery(name = "retrieve_all_part_time_employees", query = "Select p from PartTimeEmployee p")
public class PartTimeEmployee extends Employee {
    private BigDecimal hourlyWage;

    public PartTimeEmployee() {}

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}

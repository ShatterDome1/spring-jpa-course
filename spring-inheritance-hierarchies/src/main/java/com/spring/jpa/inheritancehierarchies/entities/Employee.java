package com.spring.jpa.inheritancehierarchies.entities;

import javax.persistence.*;


// Inheritance Strategies @Inheritance
// SINGLE_TABLE(default) - great for performance, bad for data integrity
// TABLE_PER_CLASS - individual tables created for each concrete subclass.
// JOINED - Tables will be created for each entity, data is fetched using a join. Bad for performance
// @MappedSuperclass - can not also be entity
// @Inheritance(strategy = InheritanceType.JOINED)
// @Entity
// @NamedQuery(name = "retrieve_all_employees", query = "Select e from Employee e")
// Scenarios:
// - data integrity - use JOINED
// - performance - use SINGLE_TABLE
@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

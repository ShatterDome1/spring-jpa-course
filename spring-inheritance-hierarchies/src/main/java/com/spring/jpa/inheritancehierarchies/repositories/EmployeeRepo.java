package com.spring.jpa.inheritancehierarchies.repositories;

import com.spring.jpa.inheritancehierarchies.entities.Employee;
import com.spring.jpa.inheritancehierarchies.entities.FullTimeEmployee;
import com.spring.jpa.inheritancehierarchies.entities.PartTimeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepo {
    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createNamedQuery("retrieve_all_employees", Employee.class);
        return query.getResultList();
    }

    public List<PartTimeEmployee> getAllPartTimeEmployees() {
        TypedQuery<PartTimeEmployee> query =
                entityManager.createNamedQuery("retrieve_all_part_time_employees", PartTimeEmployee.class);
        return query.getResultList();
    }

    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        TypedQuery<FullTimeEmployee> query =
                entityManager.createNamedQuery("retrieve_all_full_time_employees", FullTimeEmployee.class);
        return query.getResultList();
    }
}

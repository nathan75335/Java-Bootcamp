package com.contractmanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employer {
    private String name;
    private List<Employee> employees;

    public Employer(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }


    public void offerContract(Employee employee, Contract contrat) {
        employee.signContract(contrat);
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void manageRenewalContract(Employee employee, Contract contrat, int numberOfYear) {
        for (Employee employe : employees) {
            Contract contract = employe.getContract();
            if (contrat != null && contrat.getExpiryDate().isBefore(LocalDate.now().plusMonths(1))) {
                contrat.renewContract(numberOfYear);
            }
        }
    }
}

package com.contractmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemContract {

    private List<Contract> contracts;

    public SystemContract() {
        this.contracts = new ArrayList<>();
    }

    public void addContract(Contract contrat) {
        contracts.add(contrat);
        System.out.println("Contract added in the system.");
    }

    public void generateReport() {
        System.out.println("report of contracts :");
        for (Contract contrat : contracts) {
            contrat.showWorkCondition();
        }
    }
}

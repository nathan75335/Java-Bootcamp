package com.contractmanagement.entity;

public class Employee {
    private String name;
    private Contract contract;
    private boolean conditionsAccepted = false;

    public Employee(String name) {
        this.name = name;
    }

    public boolean isConditionsAccepted() {
        return conditionsAccepted;
    }
    public void setConditionsAccepted(boolean conditionsAccepted) {
        this.conditionsAccepted = conditionsAccepted;
    }
    public Contract getContract() {
        return contract;
    }

    public void signContract(Contract contract) {
        if(contract.allConditionAccepted()){
            this.contract = contract;
            this.conditionsAccepted = true;
            System.out.println("Contract signed");
        }
    }

    public void showAllConditions(){
        if(contract != null){
            for(var condition: contract.getConditions()){
                System.out.println("Condition : " + condition.getDescription() +
                        " - Accepted : " + (condition.isAccepted() ? "Yes" : "No"));
            }
        }
    }
}

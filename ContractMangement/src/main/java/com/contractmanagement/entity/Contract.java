package com.contractmanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private LocalDate signedDate;
    private LocalDate expiryDate;
    private List<Condition> conditions;
    public Contract(LocalDate signedDate, LocalDate expiryDate) {
        this.signedDate = signedDate;
        this.expiryDate = expiryDate;
        this.conditions = new ArrayList<>();
    }
    public LocalDate getSignedDate() {
        return signedDate;
    }
    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public List<Condition> getConditions() {
        return conditions;
    }
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }


    public static Contract generateContract(LocalDate signedDate, LocalDate expiryDate){
        return new Contract(signedDate, expiryDate);
    }

    public Contract renewContract(int numberOfYear){
        this.expiryDate = LocalDate.now().plusYears(numberOfYear);
        return this;
    }

    public boolean allConditionAccepted(){
        for(Condition condition : conditions){
            if(!condition.isAccepted()){
                return false;
            }
        }

        return true;
    }

    public void showWorkCondition() {
        for(var condition: conditions){
            System.out.println("Condition : " + condition.getDescription() +
                    " - Accepted : " + (condition.isAccepted() ? "Yes" : "No"));
        }
        System.out.println("Signed Date : " + this.signedDate);
        System.out.println("Expiry date : " + this.expiryDate);
    }
}

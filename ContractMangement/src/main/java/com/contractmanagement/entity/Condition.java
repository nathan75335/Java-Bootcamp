package com.contractmanagement.entity;

public class Condition {
    //cette logique peut etre ajouter si on veut que l utilisateur accepte toutes les conditions mais elle n est oas demande dans l exercie
    private String description;
    private boolean isAccepted;

    public Condition(String condition, boolean isAccepted) {
        this.description = condition;
        this.isAccepted = isAccepted;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String condition) {
        this.description = condition;
    }
    public boolean isAccepted() {
        return isAccepted;
    }
    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}

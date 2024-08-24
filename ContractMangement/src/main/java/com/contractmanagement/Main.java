package com.contractmanagement;

import com.contractmanagement.entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
            /*
            27. Système de Gestion des Contrats de Travail
                • Description : Créez une application pour gérer les contrats de travail avec création de contrats, suivi des conditions, et gestion des renouvellements.
                • Classes :
                ◦ Employé : Représente un employé ayant un contrat de travail.
                ▪ signerContrat(Contrat contrat) : Permet à l'employé de signer un contrat de travail.
                ▪ afficherConditions() : Affiche les conditions de travail stipulées dans le contrat.
                ◦ Contrat : Représente un contrat de travail signé entre l'employé et l'employeur.

                 ▪ générerContrat() : Génère un nouveau contrat de travail avec les conditions spécifiées.
                ▪ renouvelerContrat() : Renouvelle le contrat pour une période supplémentaire si les conditions sont remplies.
                ◦ Employeur : Représente l'employeur qui propose des contrats de travail.
                ▪ offrirContrat(Employé employé) : Offre un contrat de travail à un employé.
                ▪ gérerRenouvellements() : Gère les renouvellements des contrats en cours.
                ◦ SystèmeContrats : Représente le système de gestion des contrats de travail.
                    ▪ ▪
                • Logique :
                ◦ La classe
                ajouterContrat(Contrat contrat) : Ajoute un contrat à la base de données du système.
                générerRapportContrats() : Génère un rapport des contrats en cours et des renouvellements effectués.
                  Employé gère la signature des contrats et l'affichage des conditions de travail.
                 ◦ La classe Contrat gère la génération et le renouvellement des contrats de travail.
                ◦ La classe Employeur gère l'offre de contrats et les renouvellements pour les employés.
                ◦ La classe SystèmeContrats gère l'ajout de contrats et la génération de rapports sur les contrats en cours.
             */

        SystemContract systemeContrats = new SystemContract();


        Employer employer = new Employer("Tech Corp");


        Employee employee = new Employee("Alice");


        Contract contract = Contract.generateContract(LocalDate.now(), LocalDate.now().plusMonths(12));
        Condition condition1 = new Condition("Travailler 40 heures par semaine", true);
        Condition condition2 = new Condition("Pas de télétravail", true);
        contract.addCondition(condition1);
        contract.addCondition(condition2);
        employee.setConditionsAccepted(true);

        employer.offerContract(employee, contract);


        systemeContrats.addContract(contract);


        employee.showAllConditions();

        employer.manageRenewalContract(employee, contract, 1);

        systemeContrats.generateReport();

    }
}
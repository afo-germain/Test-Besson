/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testbesson;

import java.util.Scanner;

/**
 *
 * @author oyoki
 */
public class CalculMontant {

    Client exp, dest, debiteur;
    //int nbreColis, poids;
    boolean portPaye;
    double montantHt, montantTotal, taxe;

    public CalculMontant() {
        this.portPaye = true;
        this.montantHt = 0;
        this.montantTotal = 0;
        this.taxe = 0;
    }

    public void initialisation(int indexExp, int indexDest) {
        this.exp = Parser.clients.get(indexExp);
        this.dest = Parser.clients.get(indexDest);
        this.debiteur = exp;

        System.out.println("\nClient expéditeur : " + this.exp.toString());
        System.out.println("\nClient destinataire : " + this.dest.toString());

        System.out.println("\nL'expéditeur paiera t-il les frais de transport (port payé) ? : (o-Oui / n-Non)");

        Scanner sc = new Scanner(System.in);
        char choice = sc.nextLine().toLowerCase().charAt(0);

        //System.out.println(choice);
        if (choice != 'o') {
            portPaye = false;
            debiteur = dest;
        }
    }

    public void calculMontantTotal() {
        //System.out.println("==========> Montant Total");
        this.currentAmount();
        this.currentTax();
        this.montantTotal = this.montantHt + this.taxe;
        System.out.println("\n\nLe montant total est de : " + this.montantHt + " + " + this.taxe + " = " + this.montantTotal);
    }

    private int getCurrentZone() {
        int zone = 1;

        // Trouver la localité correspondante
        for (Localite localite : Parser.localites) {
            if (localite.getCodePostal().equals(this.dest.getCodePostal())
                    && localite.getVille().equals(this.dest.getVille())) {
                if (localite == null) {
                    System.out.println("Localité non trouvée !");
                    return 1;
                }

                zone = localite.getZone();
                System.out.println("\nLocalité courante : " + localite.toString());
                break;
            }
        }

        return zone;
    }

    private void currentAmount() {
        // Trouver le tarif correspondant
        Tarif tarifTrouve = new Tarif();
        int idClient = this.dest.getIdClient();
        int zone = this.getCurrentZone();

        // Continuer jusqu'à ce que le IdClientHeritage soit null
        while (tarifTrouve.getIdClientHeritage() != -1) {
            for (Tarif tarif : Parser.tarifs) {

                if (tarif.getIdClient() == idClient
                        && tarif.getCodeDepartement().equals(this.dest.getCodePostal())
                        && tarif.getZone() == zone) {
                    if (tarif == null) {
                        System.out.println("Tarif non trouvé !");
                        return;
                    }

                    tarifTrouve = tarif;

                    // Recommencer la boucle avec l'IdClientHeritage comme idClient
                    idClient = tarifTrouve.getIdClientHeritage();
                    break;
                }
            }

        }

        montantHt = tarifTrouve.getMontant();
        System.out.println("\nTarif courant: " + tarifTrouve.toString());
    }

    private void currentTax() {

        ConditionTaxation taxTrouve = new ConditionTaxation();

        for (ConditionTaxation tax : Parser.conditionTaxations) {

            if (tax.getIdClient() == this.debiteur.getIdClient()) {
                if (tax == null) {
                    System.out.println("Condition de taxation non trouvée !");
                    return;
                }

                taxTrouve = tax;
                break;
            }
        }

        if (taxTrouve.getUseTaxePortDuGenerale()) {
            this.taxe = taxTrouve.getTaxePortDu();
        } else if (taxTrouve.getUseTaxePortPayeGenerale()) {
            this.taxe = taxTrouve.getTaxePortPaye();
        }
        System.out.println("\nTaxe courante : " + taxTrouve.toString());
    }

    public Client getExp() {
        return exp;
    }

    public void setExp(Client exp) {
        this.exp = exp;
    }

    public Client getDest() {
        return dest;
    }

    public void setDest(Client dest) {
        this.dest = dest;
    }

    public Client getDebiteur() {
        return debiteur;
    }

    public void setDebiteur(Client debiteur) {
        this.debiteur = debiteur;
    }

    public boolean isPortPaye() {
        return portPaye;
    }

    public void setPortPaye(boolean portPaye) {
        this.portPaye = portPaye;
    }

    public double getMontantHt() {
        return montantHt;
    }

    public void setMontantHt(double montantHt) {
        this.montantHt = montantHt;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
    }

    @Override
    public String toString() {
        return "CalculMontant{" + "exp=" + exp + ", dest=" + dest + ", debiteur=" + debiteur + ", portPaye=" + portPaye + ", montantHt=" + montantHt + ", montantTotal=" + montantTotal + ", taxe=" + taxe + '}';
    }
}

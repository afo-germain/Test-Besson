/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbesson;

/**
 *
 * @author oyoki
 */
public class Tarif {

    int idClient, idClientHeritage;
    String codeDepartement;
    double montant;
    int zone;

    public Tarif() {
    }

    public Tarif(int idClient, int idClientHeritage, String codeDepartement, double montant, int zone) {
        this.idClient = idClient;
        this.idClientHeritage = idClientHeritage;
        this.codeDepartement = codeDepartement;
        this.montant = montant;
        this.zone = zone;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdClientHeritage() {
        return idClientHeritage;
    }

    public void setIdClientHeritage(int idClientHeritage) {
        this.idClientHeritage = idClientHeritage;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Tarif{" + "idClient=" + idClient + ", idClientHeritage=" + idClientHeritage + ", codeDepartement=" + codeDepartement + ", montant=" + montant + ", zone=" + zone + '}';
    }

}

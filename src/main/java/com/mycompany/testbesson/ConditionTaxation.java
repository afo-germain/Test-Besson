/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbesson;

/**
 *
 * @author oyoki
 */
public class ConditionTaxation {

    int idClient;
    double taxePortDu, taxePortPaye;
    boolean useTaxePortDuGenerale, useTaxePortPayeGenerale;

    public ConditionTaxation() {
    }

    public ConditionTaxation(int idClient, double taxePortDu, double taxePortPaye, boolean useTaxePortDuGenerale, boolean useTaxePortPayeGenerale) {
        this.idClient = idClient;
        this.taxePortDu = taxePortDu;
        this.taxePortPaye = taxePortPaye;
        this.useTaxePortDuGenerale = useTaxePortDuGenerale;
        this.useTaxePortPayeGenerale = useTaxePortPayeGenerale;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getTaxePortDu() {
        return taxePortDu;
    }

    public void setTaxePortDu(double taxePortDu) {
        this.taxePortDu = taxePortDu;
    }

    public double getTaxePortPaye() {
        return taxePortPaye;
    }

    public void setTaxePortPaye(double taxePortPaye) {
        this.taxePortPaye = taxePortPaye;
    }

    public boolean getUseTaxePortDuGenerale() {
        return useTaxePortDuGenerale;
    }

    public void setUseTaxePortDuGenerale(boolean useTaxePortDuGenerale) {
        this.useTaxePortDuGenerale = useTaxePortDuGenerale;
    }

    public boolean getUseTaxePortPayeGenerale() {
        return useTaxePortPayeGenerale;
    }

    public void setUseTaxePortPayeGenerale(boolean useTaxePortPayeGenerale) {
        this.useTaxePortPayeGenerale = useTaxePortPayeGenerale;
    }

    @Override
    public String toString() {
        return "ConditionTaxation{" + "idClient=" + idClient + ", taxePortDu=" + taxePortDu + ", taxePortPaye=" + taxePortPaye + ", useTaxePortDuGenerale=" + useTaxePortDuGenerale + ", useTaxePortPayeGenerale=" + useTaxePortPayeGenerale + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbesson;

/**
 *
 * @author oyoki
 */
public class Localite {

    String codePostal, ville;
    int zone;

    public Localite() {
    }

    public Localite(String codePostal, String ville, int zone) {
        this.codePostal = codePostal;
        this.ville = ville;
        this.zone = zone;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Localite{" + "codePostal=" + codePostal + ", ville=" + ville + ", zone=" + zone + '}';
    }

}

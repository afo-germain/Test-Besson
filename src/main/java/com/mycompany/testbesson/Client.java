/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbesson;

/**
 *
 * @author oyoki
 */
public class Client {
    String codePostal, raisonSociale, ville;
    int idClient;

    public Client() {
    }

    public Client(String codePostal, String raisonSociale, String ville, int idClient) {
        this.codePostal = codePostal;
        this.raisonSociale = raisonSociale;
        this.ville = ville;
        this.idClient = idClient;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Client{" + "codePostal=" + codePostal + ", raisonSociale=" + raisonSociale + ", ville=" + ville + ", idClient=" + idClient + '}';
    }
}

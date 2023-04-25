/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testbesson;

/**
 *
 * @author oyoki
 */
public class TestBesson {

    public static void main(String[] args) {
        Parser.ParseAll();
        CalculMontant calcul = new CalculMontant();
        calcul.initialisation(0, 1);
        calcul.calculMontantTotal();
    }
}

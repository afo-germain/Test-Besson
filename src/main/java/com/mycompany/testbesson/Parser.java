/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testbesson;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oyoki
 */
public class Parser {

    static List<Client> clients = new ArrayList<>();
    static List<Localite> localites = new ArrayList<>();
    static List<ConditionTaxation> conditionTaxations = new ArrayList<>();
    static List<Tarif> tarifs = new ArrayList<>();

    private static Element Read(String filename) {
        InputStream inputStream = null;
        Document document = null;

        try {
            // Récupération de l'objet InputStream pour le fichier XML
            inputStream = (new TestBesson()).getClass().getResourceAsStream("/com/mycompany/testbesson/" + filename);

            // Création d'un objet Document à partir du fichier XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = (Document) builder.parse(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermeture de l'objet InputStream
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Récupération de la racine du document XML           
        return document.getDocumentElement();
    }

    public static void ParseAll() {
        ParseClient();
        ParseConditionTaxation();
        ParseTarif();
        ParseLocalite();
    }

    public static void ParseClient() {
        //System.out.println("\n================> Clients");
        Element root = Parser.Read("client.xml");

        if (root == null) {
            return;
        }

        Client client = new Client();

        // Récupération de tous les éléments
        NodeList clientNodes = root.getElementsByTagName("ObjectClient");

        // Parcours de tous les éléments
        for (int i = 0; i < clientNodes.getLength(); i++) {
            Node clientNode = clientNodes.item(i);

            // Récupération des informations
            Element clientElement = (Element) clientNode;
            String idClientStr = clientElement.getElementsByTagName("idClient").item(0).getTextContent();
            String raisonSociale = clientElement.getElementsByTagName("raisonSociale").item(0).getTextContent();
            String codePostal = clientElement.getElementsByTagName("codePostal").item(0).getTextContent();
            String ville = clientElement.getElementsByTagName("ville").item(0).getTextContent();

            // Casting
            int idClient = idClientStr.isEmpty() ? 0 : Integer.parseInt(idClientStr);

            client = new Client(codePostal, raisonSociale, ville, idClient);

            // Impression des informations
            //System.out.println(client.toString());
            // Ajout à la liste
            clients.add(client);
        }
    }

    public static void ParseLocalite() {
        //System.out.println("\n================> Localités");
        Element root = Parser.Read("localite.xml");

        if (root == null) {
            return;
        }

        Localite localite = new Localite();

        // Récupération de tous les éléments
        NodeList localiteNodes = root.getElementsByTagName("ObjectLocalite");

        // Parcours de tous les élémentsclient
        for (int i = 0; i < localiteNodes.getLength(); i++) {
            Node localiteNode = localiteNodes.item(i);

            // Récupération des informations
            Element localiteElement = (Element) localiteNode;
            String codePostal = localiteElement.getElementsByTagName("codePostal").item(0).getTextContent();
            String ville = localiteElement.getElementsByTagName("ville").item(0).getTextContent();
            String zoneStr = localiteElement.getElementsByTagName("zone").item(0).getTextContent();

            // Casting
            int zone = zoneStr.isEmpty() ? 0 : Integer.parseInt(zoneStr);

            // Mise à jour de l'objet
            localite = new Localite(codePostal, ville, zone);

            // Impression des informations
            //System.out.println(localite.toString());
            // Ajout à la liste
            localites.add(localite);
        }
    }

    public static void ParseConditionTaxation() {
        //System.out.println("\n================> Condition de taxations");
        Element root = Parser.Read("conditiontaxation.xml");

        if (root == null) {
            return;
        }

        ConditionTaxation conditionTaxation = new ConditionTaxation();

        // Récupération de tous les éléments
        NodeList conditionTaxationNodes = root.getElementsByTagName("ObjectConditionTaxation");

        // Parcours de tous les élémentsclient
        for (int i = 0; i < conditionTaxationNodes.getLength(); i++) {
            Node conditionTaxationNode = conditionTaxationNodes.item(i);

            // Récupération des informations
            Element conditionTaxationElement = (Element) conditionTaxationNode;
            String idClientStr = conditionTaxationElement.getElementsByTagName("idClient").item(0).getTextContent();
            String taxePortDuStr = conditionTaxationElement.getElementsByTagName("taxePortDu").item(0).getTextContent();
            String taxePortPayeStr = conditionTaxationElement.getElementsByTagName("taxePortPaye").item(0).getTextContent();
            String useTaxePortDuGeneraleStr = conditionTaxationElement.getElementsByTagName("useTaxePortDuGenerale").item(0).getTextContent();
            String useTaxePortPayeGeneraleStr = conditionTaxationElement.getElementsByTagName("useTaxePortPayeGenerale").item(0).getTextContent();

            // Casting
            int idClient = idClientStr.isEmpty() ? 0 : Integer.parseInt(idClientStr);
            double taxePortDu = taxePortDuStr.isEmpty() ? 0 : Double.parseDouble(taxePortDuStr);
            double taxePortPaye = taxePortPayeStr.isEmpty() ? 0 : Double.parseDouble(taxePortPayeStr);
            boolean useTaxePortDuGenerale = useTaxePortDuGeneraleStr.isEmpty() ? Boolean.FALSE : Boolean.parseBoolean(useTaxePortDuGeneraleStr);
            boolean useTaxePortPayeGenerale = useTaxePortPayeGeneraleStr.isEmpty() ? Boolean.FALSE : Boolean.parseBoolean(useTaxePortPayeGeneraleStr);

            // Mise à jour de l'objet
            conditionTaxation = new ConditionTaxation(idClient, taxePortDu, taxePortPaye, useTaxePortDuGenerale, useTaxePortPayeGenerale);

            // Impression des informations
            //System.out.println(conditionTaxation.toString());
            // Ajout à la liste
            conditionTaxations.add(conditionTaxation);
        }
    }

    public static void ParseTarif() {
        //System.out.println("\n================> Tarifs");
        Element root = Parser.Read("tarif.xml");

        if (root == null) {
            return;
        }

        Tarif tarif = new Tarif();

        // Récupération de tous les éléments
        NodeList tarifNodes = root.getElementsByTagName("ObjectTarif");

        // Parcours de tous les élémentsclient
        for (int i = 0; i < tarifNodes.getLength(); i++) {
            Node tarifNode = tarifNodes.item(i);

            // Récupération des informations
            Element tarifElement = (Element) tarifNode;
            String idClientStr = tarifElement.getElementsByTagName("idClient").item(0).getTextContent();
            String idClientHeritageStr = tarifElement.getElementsByTagName("idClientHeritage").item(0).getTextContent();
            String montantStr = tarifElement.getElementsByTagName("montant").item(0).getTextContent();
            String zoneStr = tarifElement.getElementsByTagName("zone").item(0).getTextContent();

            //Casting
            int idClient = idClientStr.isEmpty() ? 0 : Integer.parseInt(idClientStr);
            int idClientHeritage = idClientHeritageStr.isEmpty() ? -1 : Integer.parseInt(idClientHeritageStr);
            String codeDepartement = tarifElement.getElementsByTagName("codeDepartement").item(0).getTextContent();
            double montant = montantStr.isEmpty() ? 0 : Double.parseDouble(montantStr);
            int zone = zoneStr.isEmpty() ? 0 : Integer.parseInt(zoneStr);

            // Mise à jour de l'objet
            tarif = new Tarif(idClient, idClientHeritage, codeDepartement, montant, zone);

            // Impression des informations
            //System.out.println(tarif.toString());
            // Ajout à la liste
            tarifs.add(tarif);
        }
    }
}

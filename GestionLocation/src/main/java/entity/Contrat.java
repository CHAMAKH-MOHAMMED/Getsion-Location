/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

public class Contrat {

    private int ID;
    private String nomC;
    private String prenomC;
    private String cin;
    private String nContrat;
    private String etatOcation;
    private String licenceConduit;
    private Date dateDebut;
    private Date dateFin;
    private String prix;

    private Voiture voiture; // Association avec la classe Voiture

    // Constructeur
    public Contrat(int ID, String nomC, String prenomC, String cin, String nContrat,
            String etatOcation, String licenceConduit, Date dateDebut,
            Date dateFin, String prix, Voiture voiture) {
        this.ID = ID;
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.cin = cin;
        this.nContrat = nContrat;
        this.etatOcation = etatOcation;
        this.licenceConduit = licenceConduit;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.voiture = voiture;
    }
 public Contrat( String nomC, String prenomC, String cin, String nContrat,
            String etatOcation, String licenceConduit, Date dateDebut,
            Date dateFin, String prix, Voiture voiture) {
      
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.cin = cin;
        this.nContrat = nContrat;
        this.etatOcation = etatOcation;
        this.licenceConduit = licenceConduit;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.voiture = voiture;
    }

    public Contrat() {
    }

    // Getters et Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getPrenomC() {
        return prenomC;
    }

    public void setPrenomC(String prenomC) {
        this.prenomC = prenomC;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getnContrat() {
        return nContrat;
    }

    public void setnContrat(String nContrat) {
        this.nContrat = nContrat;
    }

    public String getEtatOcation() {
        return etatOcation;
    }

    public void setEtatOcation(String etatOcation) {
        this.etatOcation = etatOcation;
    }

    public String getLicenceConduit() {
        return licenceConduit;
    }

    public void setLicenceConduit(String licenceConduit) {
        this.licenceConduit = licenceConduit;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
    
    
      public Object[] toArray() {
        return new Object[]{
            nomC+" "+prenomC,
            etatOcation,
            prix,
            nContrat};
    }

}

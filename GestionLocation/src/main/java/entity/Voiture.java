package entity;

public class Voiture {

    private int id;
    private String marque;
    private String modele;
    private String annee;
    private String immatriculation;
    private String typeCarburant;
    private String kilometrage;
    private String couleur;
    private String nombrePortes;
    private String typeTransmission;
    private String numeroChassis;
    private String prix;
    private String etat;

    // Constructeur par défaut
    public Voiture() {
    }

    // Constructeur avec tous les champs sauf ID (qui est auto-increment)
    public Voiture(String marque, String modele, String annee, String immatriculation,
            String typeCarburant, String kilometrage, String couleur,
            String nombrePortes, String typeTransmission, String numeroChassis,
            String prix, String etat) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
        this.typeCarburant = typeCarburant;
        this.kilometrage = kilometrage;
        this.couleur = couleur;
        this.nombrePortes = nombrePortes;
        this.typeTransmission = typeTransmission;
        this.numeroChassis = numeroChassis;
        this.prix = prix;
        this.etat = etat;
    }

    // Constructeur avec ID (utile pour les opérations de mise à jour)
    public Voiture(int id, String marque, String modele, String annee, String immatriculation,
            String typeCarburant, String kilometrage, String couleur,
            String nombrePortes, String typeTransmission, String numeroChassis,
            String prix, String etat) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
        this.typeCarburant = typeCarburant;
        this.kilometrage = kilometrage;
        this.couleur = couleur;
        this.nombrePortes = nombrePortes;
        this.typeTransmission = typeTransmission;
        this.numeroChassis = numeroChassis;
        this.prix = prix;
        this.etat = etat;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNombrePortes() {
        return nombrePortes;
    }

    public void setNombrePortes(String nombrePortes) {
        this.nombrePortes = nombrePortes;
    }

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission;
    }

    public String getNumeroChâssis() {
        return numeroChassis;
    }

    public void setNumeroChâssis(String numeroChâssis) {
        this.numeroChassis = numeroChâssis;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Voiture{"
                + "id=" + id
                + ", marque='" + marque + '\''
                + ", modele='" + modele + '\''
                + ", annee='" + annee + '\''
                + ", immatriculation='" + immatriculation + '\''
                + ", typeCarburant='" + typeCarburant + '\''
                + ", kilometrage='" + kilometrage + '\''
                + ", couleur='" + couleur + '\''
                + ", nombrePortes='" + nombrePortes + '\''
                + ", typeTransmission='" + typeTransmission + '\''
                + ", numeroChâssis='" + numeroChassis + '\''
                + ", prix='" + prix + '\''
                + ", etat='" + etat + '\''
                + '}';

    }

    public Object[] toArray() {
        return new Object[]{
            marque,
            modele,
            immatriculation,
            annee,};
    }

}

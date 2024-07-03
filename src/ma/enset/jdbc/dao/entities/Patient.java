package ma.enset.jdbc.dao.entities;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private int id_patient;
    private String nom;
    private String prenom;
    private String cin;
    private Date date_naissance;
    private String email;
    private String telephone;

    public Patient() {
    }

    public Patient(String nom, String prenom, String cin, Date date_naissance, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.date_naissance = date_naissance;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id_patient=" + id_patient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", date_naissance=" + date_naissance +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

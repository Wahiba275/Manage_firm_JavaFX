package ma.enset.jdbc.dao.entities;

import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {
    private int id_consultation;
    private Date date_consultation;
    private Medecin medecin;
    private Patient patient;


    public Consultation() {
    }

    public Consultation(Date date_consultation,Medecin medecin , Patient patient) {
        this.date_consultation = date_consultation;
        this.medecin=medecin;
        this.patient=patient;
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id_consultation=" + id_consultation +
                ", date_consultation=" + date_consultation +
                ", medecin=" + medecin+
                ", patient=" + patient+
                '}';
    }
}

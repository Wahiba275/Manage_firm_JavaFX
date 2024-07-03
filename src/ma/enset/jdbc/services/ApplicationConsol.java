package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.*;
import ma.enset.jdbc.dao.entities.Consultation;
import ma.enset.jdbc.dao.entities.Medecin;
import ma.enset.jdbc.dao.entities.Patient;
import java.sql.*;
import java.util.List;

public class ApplicationConsol {
    public static void main(String[] args) throws SQLException {

        Patient p=new Patient() ;
        Medecin m =new Medecin();
        /*p.setNom("Nabila");p.setPrenom("ALAMI");p.setCin("A1234567");p.setDate_naissance(new Date(2004,4,15));
        p.setEmail("nabila.ALAMI@gmail.com");p.setTelephone("0615487857");
        m.setNom("Chayma");m.setPrenom("ALAOUI");m.setEmail("Chayma.alaoui@gamil.com");m.setTel("0648795424");
        metierPatient.add(p);
        metierMedecin.add(m);

        */
        ICabinetMetierPatient metierPatient = new ICabinetMetierPatientImpl();
        ICabinetMetierMedecin metierMedecin = new ICabinetMetierMedecinImpl();
        ICabinetConsultation  consultation = new ICabinetMetierConsultationImpl();
        p.setNom("nom1");p.setPrenom("prenom1");p.setCin("A1234567");p.setDate_naissance(new Date(2001,4,15));
        p.setEmail("nom1.prenom1@gmail.com");p.setTelephone("0615487857");
        m.setNom("nom2");m.setPrenom("prenom2");m.setEmail("nom2.prenom2@gamil.com");m.setTel("0648795424");
        metierPatient.add(p);
        metierMedecin.add(m);
        List<Patient> patients = metierPatient.getAll();
        List<Medecin> medecins = metierMedecin.getAll();
        Consultation c = new Consultation(new Date(2023,01,17) , m,p);
        consultation.add(c);
        System.out.println(c.toString());
      /*

        for (Medecin medecin: medecins){
                  System.out.println(medecin.toString());
                  }
        for (Patient patient:patients){
            System.out.println(patient.toString());
        }

    */

    }
}


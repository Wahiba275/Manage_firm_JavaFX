package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.entities.Consultation;
import ma.enset.jdbc.dao.entities.Medecin;
import ma.enset.jdbc.dao.entities.Patient;

import java.util.List;

public interface CatalogueService {
       List<Medecin> getAllMedecin();
       Medecin addMedecin(Medecin medecin);
       boolean deleteMedecin(Medecin medecin);

    List<Patient> getAllPatient();
    Patient addPatient(Patient patient);
    boolean deletePatient(Patient patient);
    List<Patient> findByKey1(String key);
    //----------Consultations----------
    List<Consultation> getAllConsultation(Consultation c);
    boolean deleteConsultation(Consultation c);
}

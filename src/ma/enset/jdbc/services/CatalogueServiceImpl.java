package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.ICabinetMetierMedecin;
import ma.enset.jdbc.dao.ICabinetMetierPatient;
import ma.enset.jdbc.dao.entities.Consultation;
import ma.enset.jdbc.dao.ICabinetConsultation;
import ma.enset.jdbc.dao.entities.Medecin;
import ma.enset.jdbc.dao.entities.Patient;

import java.util.List;

public class CatalogueServiceImpl implements CatalogueService{
    ICabinetMetierMedecin metierMedecin;
    ICabinetMetierPatient metierPatient;
    ICabinetConsultation consultation;

    public CatalogueServiceImpl(ICabinetMetierMedecin metierMedecin, ICabinetMetierPatient metierPatient, ICabinetConsultation consultation) {
        this.metierMedecin = metierMedecin;
        this.metierPatient = metierPatient;
        this.consultation = consultation;
    }

    @Override
    public List<Medecin> getAllMedecin() {
        return metierMedecin.getAll();
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        return metierMedecin.add(medecin);
    }

    @Override
    public boolean deleteMedecin(Medecin medecin) {
        return metierMedecin.delete(medecin);
    }

    @Override
    public List<Patient> getAllPatient() {
        return metierPatient.getAll();
    }

    @Override
    public Patient addPatient(Patient patient) {
        return metierPatient.add(patient);
    }

    @Override
    public boolean deletePatient(Patient patient) {
        return metierPatient.delete(patient);
    }

    @Override
    public List<Patient> findByKey1(String key) {
        return metierPatient.findByKey(key);
    }

    @Override
    public List<Consultation> getAllConsultation(Consultation c) {
        return consultation.getAll();
    }

    @Override
    public boolean deleteConsultation(Consultation c) {
        return consultation.delete(c);
    }
}

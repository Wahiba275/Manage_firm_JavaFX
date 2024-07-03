package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Patient;

import java.util.List;

public interface ICabinetMetierPatient extends ICabinetMetier<Patient> {
    List<Patient> findByKey(String key);
    Patient add(Patient patient);
}

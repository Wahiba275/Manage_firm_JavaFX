package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Medecin;
import ma.enset.jdbc.dao.entities.Patient;

import java.util.List;

public interface ICabinetMetierMedecin extends  ICabinetMetier<Medecin> {
    Medecin add(Medecin medecin);
}

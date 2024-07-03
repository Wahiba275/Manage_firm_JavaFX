package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Consultation;
import ma.enset.jdbc.dao.entities.Medecin;

public interface ICabinetConsultation extends ICabinetMetier<Consultation> {
    Consultation add(Consultation c);
}

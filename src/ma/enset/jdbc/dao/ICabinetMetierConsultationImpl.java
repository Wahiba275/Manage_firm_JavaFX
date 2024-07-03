package ma.enset.jdbc.dao;
import ma.enset.jdbc.dao.entities.Consultation;
import ma.enset.jdbc.dao.entities.Medecin;
import ma.enset.jdbc.dao.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ICabinetMetierConsultationImpl implements ICabinetConsultation {

    @Override
    public List<Consultation> getAll() {
        List<Consultation> consultations = new ArrayList<>();
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pStm = connection.prepareStatement("select  * from consultation");
            ResultSet rs = pStm.executeQuery();
            while(rs.next()){
                Consultation c = new Consultation();
                c.setId_consultation(rs.getInt("ID_CONSULTATION"));
                c.setDate_consultation(rs.getDate("DATE_CONSULTATION"));
                Medecin medecin=new Medecin();
                Patient patient=new Patient();
                PreparedStatement pstm1 = connection.prepareStatement("select * from medecin where ID_MEDECIN=?");
                pstm1.setInt(1,rs.getInt("ID_MEDECIN"));
                ResultSet rs1= pstm1.executeQuery();
                while(rs1.next()){
                    medecin.setId_medecin(rs.getInt("ID_MEDECIN"));
                    medecin.setNom(rs.getString("NOM"));
                    medecin.setPrenom(rs.getString("PRENOM"));
                    medecin.setTel(rs.getString("TEL"));
                    medecin.setEmail(rs.getString("EMAIL"));
                }
                PreparedStatement pstm2=connection.prepareStatement("select * from patient where ID_PATIENT=?");
                pstm2.setInt(1,rs.getInt("ID_PATIENT"));
                ResultSet rs2 = pstm2.executeQuery();
                while(rs2.next()){
                    patient.setId_patient(rs.getInt("ID_PATIENT"));
                    patient.setNom(rs.getString("NOM"));
                    patient.setPrenom(rs.getString("PRENOM"));
                    patient.setCin(rs.getString("CIN"));
                    patient.setTelephone(rs.getString("TELEPHONE"));
                    patient.setEmail(rs.getString("EMAIL"));
                    patient.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                }
                c.setMedecin(medecin);
                c.setPatient(patient);
                consultations.add(c);


            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public boolean delete(Consultation c) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from patient where ID_CONSULTATION = ?");
            pstm.setInt(1,c.getId_consultation());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Consultation add(Consultation c) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into consultation(NOM , " +
                    "PRENOM, CIN , TELEPHONE,EMAIL,DATE_NAISSANCE) values(?,?,?,?,?,?)");
            pstm.setString(1,c.getNom());
            pstm.setString(2,patient.getPrenom());
            pstm.setString(3
            pstm.executeUpdate();
            return  patient ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ICabinetMetierPatientImpl implements ICabinetMetierPatient{
    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pStm = connection.prepareStatement("select  * from patient");
            ResultSet rs = pStm.executeQuery();
            while(rs.next()){
                Patient p = new Patient();
                p.setId_patient(rs.getInt("ID_PATIENT"));
                p.setNom(rs.getString("NOM"));
                p.setPrenom(rs.getString("PRENOM"));
                p.setCin(rs.getString("CIN"));
                p.setTelephone(rs.getString("TELEPHONE"));
                p.setEmail(rs.getString("EMAIL"));
                p.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                patients.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public boolean delete(Patient o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from patient where ID_PATIENT = ?");
            pstm.setInt(1,o.getId_patient());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Patient> findByKey(String key) {

        List<Patient> produits = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from  patient " +
                    "where NOM like ?");
            pstm.setString(1,"%"+key+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Patient p = new Patient();
                p.setId_patient(rs.getInt("ID_PATIENT"));
                p.setNom(rs.getString("NOM"));
                p.setPrenom(rs.getString("PRENOM"));
                p.setCin(rs.getString("CIN"));
                p.setTelephone(rs.getString("TELEPHONE"));
                p.setEmail(rs.getString("EMAIL"));
                p.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                produits.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Patient add(Patient patient) {

        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into patient(NOM , " +
                    "PRENOM, CIN , TELEPHONE,EMAIL,DATE_NAISSANCE) values(?,?,?,?,?,?)");
            pstm.setString(1,patient.getNom());
            pstm.setString(2,patient.getPrenom());
            pstm.setString(3,patient.getCin());
            pstm.setString(4,patient.getTelephone());
            pstm.setString(5,patient.getEmail());
            java.util.Date utilDate = patient.getDate_naissance();
            pstm.setDate(6, new java.sql.Date(utilDate.getTime()));
            pstm.executeUpdate();
            return  patient ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

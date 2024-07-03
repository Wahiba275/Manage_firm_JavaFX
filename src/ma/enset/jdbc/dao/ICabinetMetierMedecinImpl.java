package ma.enset.jdbc.dao;
import ma.enset.jdbc.dao.entities.Medecin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ICabinetMetierMedecinImpl implements ICabinetMetierMedecin{

    @Override
    public List getAll() {
        List<Medecin> medecins = new ArrayList<>();
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pStm = connection.prepareStatement("select  * from medecin");
            ResultSet rs = pStm.executeQuery();
            while(rs.next()){
                Medecin medecin = new Medecin();
                medecin.setId_medecin(rs.getInt("ID_MEDECIN"));
                medecin.setNom(rs.getString("NOM"));
                medecin.setPrenom(rs.getString("PRENOM"));
                medecin.setTel(rs.getString("TEL"));
                medecin.setEmail(rs.getString("EMAIL"));
                medecins.add(medecin);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return medecins;
    }
    @Override
    public boolean delete(Medecin o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from medecin where ID_MEDECIN = ?");
            pstm.setInt(1,o.getId_medecin());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Medecin add(Medecin medecin) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into medecin(NOM ,PRENOM, EMAIL,TEL) values(?,?,?,?)");
            pstm.setString(1,medecin.getNom());
            pstm.setString(2,medecin.getPrenom());
            pstm.setString(3,medecin.getEmail());
            pstm.setString(4,medecin.getTel());
            pstm.executeUpdate();
            return  medecin ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

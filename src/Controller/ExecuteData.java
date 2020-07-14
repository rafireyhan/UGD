package Controller;

import Connection.ConnectionManager;
import Model.Pasien;
import Model.Dokter;
import Model.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteData {
    //Create Data Pasien
    public String InsertPasien(Pasien psn,Dokter dkt,Ruang rng){
    String query ="INSERT INTO pasien (Nama,Gender,Umur,Alamat,Wali,Keterangan,Tanggal_Masuk,Triage,ID_Dokter,ID_Ruang,Status) value(?,?,?,?,?,?,?,?,?,?,?)";
    ConnectionManager conMan = new ConnectionManager();
    Connection conn = conMan.Logon();
    String Respon;
    try {
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setString(1, psn.getNama());
        pstm.setString(2, psn.getGender());
        pstm.setString(3, psn.getUmur());
        pstm.setString(4, psn.getAlamat());
        pstm.setString(5, psn.getWali());
        pstm.setString(6, psn.getKeterangan());
        pstm.setString(7, psn.getTanggal());
        pstm.setString(8, psn.getTriage());
        pstm.setString(9, dkt.getIdDokter());
        pstm.setString(10, rng.getIdRuang());
        pstm.setString(11, psn.getStatus());
        pstm.executeUpdate();
        Respon="Insert Sukses";
        } catch (SQLException ex) {
        Respon="Insert Gagal";

        Logger.getLogger(ExecuteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return Respon;
    }
    
    //Array List tabel Pasien
    public List<Pasien> ListPsn(){
        List<Pasien> arlistpsn = new ArrayList<>();
        String query = "SELECT *FROM pasien";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Pasien psn = new Pasien();
                psn.setId(rs.getString("ID_Pasien"));
                psn.setNama(rs.getString("Nama"));
                psn.setGender(rs.getString("Gender"));
                psn.setUmur(rs.getString("Umur"));
                psn.setAlamat(rs.getString("Alamat"));
                psn.setWali(rs.getString("Wali"));
                psn.setKeterangan(rs.getString("Keterangan"));
                psn.setTanggal(rs.getString("Tanggal_masuk"));
                psn.setTriage(rs.getString("Triage"));
                psn.setStatus(rs.getString("Status"));
                psn.setDokterID(rs.getString("ID_Dokter"));
                psn.setRuangID(rs.getString("ID_Ruang"));
                arlistpsn.add(psn);
            }
        } catch (SQLException ex){
            Logger.getLogger(ExecuteData.class.getName()).log(Level.SEVERE, null, ex); 
        }
        conMan.Logoff();
        return arlistpsn;
    }
    
    //Array List tabel Dokter
    public List<Dokter> ListDkt(){
        List<Dokter> arlistdkt = new ArrayList<>();
        String query = "SELECT *FROM dokter";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Dokter dkt = new Dokter();
                dkt.setIdDokter(rs.getString("ID_Dokter"));
                dkt.setNamaDok(rs.getString("Nama"));
                dkt.setSpesialis(rs.getString("Spesialis"));
                dkt.setJadwal(rs.getString("Jadwal"));              
                arlistdkt.add(dkt);
            }
        } catch (SQLException ex){
            Logger.getLogger(ExecuteData.class.getName()).log(Level.SEVERE, null, ex); 
        }
        conMan.Logoff();
        return arlistdkt;
    }
    
    //Array List tabel Ruang
    public List<Ruang> ListRng(){
        List<Ruang> arlistrng = new ArrayList<>();
        String query = "SELECT *FROM ruang";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Ruang rng = new Ruang();
                rng.setIdRuang(rs.getString("ID_Ruang"));
                rng.setNamaRuang(rs.getString("Nama"));
                rng.setStatusRuang(rs.getString("Status"));
                arlistrng.add(rng);
            }
        } catch (SQLException ex){
            Logger.getLogger(ExecuteData.class.getName()).log(Level.SEVERE, null, ex); 
        }
        conMan.Logoff();
        return arlistrng;
    }
    
    public String apdetPasien(Pasien psn,Dokter dkt,Ruang rng){
        String hasil="";
        String query ="UPDATE pasien " + "SET Nama= ?, Gender= ?, Umur= ?, Alamat= ?, Wali= ?, Keterangan= ?, Tanggal_masuk= ?, Triage= ?, ID_Dokter= ?, ID_Ruang= ?, Status= ? " + "WHERE ID_Pasien= ?";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, psn.getNama());
            pstm.setString(2, psn.getGender());
            pstm.setString(3, psn.getUmur());
            pstm.setString(4, psn.getAlamat());
            pstm.setString(5, psn.getWali());
            pstm.setString(6, psn.getKeterangan());
            pstm.setString(7, psn.getTanggal());
            pstm.setString(8, psn.getTriage());
            pstm.setString(9, dkt.getIdDokter());
            pstm.setString(10, rng.getIdRuang());
            pstm.setString(11, psn.getStatus());
            pstm.setString(12, psn.getId());
            pstm.executeUpdate();
            hasil="Berhasil";
        } catch (SQLException ex) {
            hasil="Gagal";

        Logger.getLogger(ExecuteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil; }
}

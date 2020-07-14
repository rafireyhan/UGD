package Model;

import java.sql.Date;

public class Pasien {
    private String id,Nama,Umur,Alamat,Keterangan,Status,Gender,Wali,Triage,Tanggal;
    private String dokterID,ruangID;

    public String getDokterID() {
        return dokterID;
    }

    public void setDokterID(String dokterID) {
        this.dokterID = dokterID;
    }

    public String getRuangID() {
        return ruangID;
    }

    public void setRuangID(String ruangID) {
        this.ruangID = ruangID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTriage() {
        return Triage;
    }

    public void setTriage(String Triage) {
        this.Triage = Triage;
    }

    public String getWali() {
        return Wali;
    }

    public void setWali(String Wali) {
        this.Wali = Wali;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getUmur() {
        return Umur;
    }

    public void setUmur(String Umur) {
        this.Umur = Umur;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }
}

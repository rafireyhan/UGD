package Model;

public class Dokter {
    public String idDokter,NamaDok,Spesialis,Jadwal;

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public void setNamaDok(String NamaDok) {
        this.NamaDok = NamaDok;
    }

    public void setSpesialis(String Spesialis) {
        this.Spesialis = Spesialis;
    }

    public void setJadwal(String Jadwal) {
        this.Jadwal = Jadwal;
    }

    public String getNamaDok() {
        return NamaDok;
    }

    public String getSpesialis() {
        return Spesialis;
    }

    public String getJadwal() {
        return Jadwal;
    }
}

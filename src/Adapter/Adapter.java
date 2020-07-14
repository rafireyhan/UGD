package Adapter;

import Controller.ExecuteData;
import Model.Pasien;
import Model.Dokter;
import Model.Ruang;
import java.util.List;

public class Adapter {
    //Tabel Data Pasien
    public Object[][] getAllGuru(){
        ExecuteData em = new ExecuteData();
        List<Pasien>lstpsn= em.ListPsn();
        Object[][] datapsn= new Object[lstpsn.size()][12];
       
        int mysize=0;
        for (Pasien psn:lstpsn){
            datapsn[mysize] [0]=psn.getId();
            datapsn[mysize] [1]=psn.getNama();
            datapsn[mysize] [2]=psn.getGender();
            datapsn[mysize] [3]=psn.getUmur();
            datapsn[mysize] [4]=psn.getAlamat();
            datapsn[mysize] [5]=psn.getWali();
            datapsn[mysize] [6]=psn.getKeterangan();
            datapsn[mysize] [7]=psn.getTanggal();
            datapsn[mysize] [8]=psn.getTriage();
            datapsn[mysize] [9]=psn.getStatus();
            datapsn[mysize] [10]=psn.getDokterID();
            datapsn[mysize] [11]=psn.getRuangID();
            mysize++;
        }
        return datapsn;
    }
    
    //Tabel Dokter
    public Object[][] getAllGuru1(){
        ExecuteData em = new ExecuteData();
        List<Dokter>lstdkt= em.ListDkt();
        Object[][] datadkt= new Object[lstdkt.size()][4];
        int mysize=0;
        for (Dokter dkt:lstdkt){
            datadkt[mysize] [0]=dkt.getIdDokter();
            datadkt[mysize] [1]=dkt.getNamaDok();
            datadkt[mysize] [2]=dkt.getSpesialis();
            datadkt[mysize] [3]=dkt.getJadwal();
            mysize++;
        }
        return datadkt;
    }
    
    //Tabel Ruang
    public Object[][] getAllGuru2(){
        ExecuteData em = new ExecuteData();
        List<Ruang>lstrng= em.ListRng();
        Object[][] datarng= new Object[lstrng.size()][3];
        int mysize=0;
        for (Ruang rng:lstrng){
            datarng[mysize] [0]=rng.getIdRuang();
            datarng[mysize] [1]=rng.getNamaRuang();
            datarng[mysize] [2]=rng.getStatusRuang();
            mysize++;
        }
        return datarng;
    }
}

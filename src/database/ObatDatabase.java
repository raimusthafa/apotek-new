package database;

import java.util.ArrayList;
import model.Obat;

public class ObatDatabase {
    private ArrayList<Obat> daftarObat;

    public ObatDatabase() {
        daftarObat = new ArrayList<>();
        // Tambahkan beberapa data awal
        daftarObat.add(new Obat("OBT001", "Paracetamol", 100, 5000));
        daftarObat.add(new Obat("OBT002", "Amoxicillin", 50, 15000));
        daftarObat.add(new Obat("OBT003", "Vitamin C", 200, 3000));
    }

    public ArrayList<Obat> getDaftarObat() {
        return daftarObat;
    }

    public void tambahObat(Obat obat) {
        daftarObat.add(obat);
    }

    public Obat cariObatByKode(String kode) {
        for (Obat obat : daftarObat) {
            if (obat.getKode().equals(kode)) {
                return obat;
            }
        }
        return null;
    }

    public boolean hapusObat(String kode) {
        for (int i = 0; i < daftarObat.size(); i++) {
            if (daftarObat.get(i).getKode().equals(kode)) {
                daftarObat.remove(i);
                return true;
            }
        }
        return false;
    }

    // Cari obat berdasarkan nama (partial, case-insensitive)
    public ArrayList<Obat> cariObatByNama(String nama) {
        ArrayList<Obat> hasil = new ArrayList<>();
        if (nama == null) {
            return hasil;
        }
        String namaLower = nama.toLowerCase().trim();
        for (Obat obat : daftarObat) {
            if (obat.getNama() != null && obat.getNama().toLowerCase().contains(namaLower)) {
                hasil.add(obat);
            }
        }
        return hasil;
    }
}

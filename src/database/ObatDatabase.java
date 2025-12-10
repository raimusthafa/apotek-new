package database;

import model.Obat;
import java.util.ArrayList;

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
}

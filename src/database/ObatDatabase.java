package database;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Obat;

public class ObatDatabase {
    private ArrayList<Obat> daftarObat;

    public ObatDatabase() {
        daftarObat = new ArrayList<>();
        // Tambahkan beberapa data awal
        daftarObat.add(new Obat("OBT001", "Paracetamol 500mg",100, 5000,
                LocalDate.of(2026, 6, 15), "Analgesik"));
        daftarObat.add(new Obat("OBT002", "Amoxicillin 500mg", 50, 15000,
                LocalDate.of(2025, 12, 20), "Antibiotik"));
        daftarObat.add(new Obat("OBT003", "Vitamin C 1000mg", 75, 25000,
                LocalDate.of(2026, 3, 10), "Vitamin"));
        daftarObat.add(new Obat("OBT004", "Antasida Tablet", 120, 8000,
                LocalDate.of(2025, 12, 25), "Antasida"));
        daftarObat.add(new Obat("OBT005", "Ibuprofen 400mg", 60, 12000,
                LocalDate.of(2026, 1, 5), "Analgesik"));
    }

    public ArrayList<Obat> getDaftarObat() {
        return daftarObat;
    }

    public void tambahObat(Obat obat) {
        daftarObat.add(obat);
    }

    public Obat cariObatByKode(String kode) {
        for (Obat obat : daftarObat) {
            if (obat.getKode().equalsIgnoreCase(kode)) {
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

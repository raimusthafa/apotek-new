package service;

import database.ObatDatabase;
import java.util.ArrayList;
import model.Obat;

public class SearchingService {
    private ObatDatabase database;

    public SearchingService(ObatDatabase database) {
        this.database = database;
    }

    // Cari berdasarkan nama (partial, case-insensitive)
    public ArrayList<Obat> cariByNama(String keyword) {
        ArrayList<Obat> hasil = new ArrayList<>();
        if (keyword == null) return hasil;

        String q = keyword.toLowerCase().trim();
        for (Obat obat : database.getDaftarObat()) {
            if (obat.getNama() != null && obat.getNama().toLowerCase().contains(q)) {
                hasil.add(obat);
            }
        }
        return hasil;
    }

    // Cari berdasarkan kode
    public Obat cariByKode(String kodeObat) {
        if (kodeObat == null) return null;

        for (Obat obat : database.getDaftarObat()) {
            if (obat.getKode() != null && obat.getKode().equalsIgnoreCase(kodeObat.trim())) {
                return obat;
            }
        }
        return null;
    }

    // Placeholder: model Obat saat ini tidak memiliki kategori/expired fields
    public ArrayList<Obat> cariByKategori(String kategori) {
        return new ArrayList<>();
    }

    // Tampilkan hasil sederhana
    public static void tampilkanHasilPencarian(ArrayList<Obat> hasil, String keyword) {
        if (hasil == null || hasil.isEmpty()) {
            System.out.println("\nTidak ada obat yang ditemukan dengan keyword: '" + keyword + "'");
            return;
        }

        System.out.println("\n=== HASIL PENCARIAN: '" + keyword + "' ===");
        for (int i = 0; i < hasil.size(); i++) {
            System.out.println("\nObat ke-" + (i + 1));
            hasil.get(i).tampilkanInfo();
        }
    }

    public static void tampilkanDetailObat(Obat obat) {
        if (obat == null) {
            System.out.println("\nObat tidak ditemukan!");
            return;
        }
        System.out.println("\n=== DETAIL OBAT ===");
        obat.tampilkanInfo();
    }
}

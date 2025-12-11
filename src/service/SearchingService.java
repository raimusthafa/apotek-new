package service;

import database.ObatDatabase;
import java.util.ArrayList;
import model.Obat;

public class SearchingService {

    public static ArrayList<Obat> cariByNama(String keyword) {
        ArrayList<Obat> hasil = new ArrayList<>();
        ArrayList<Obat> daftarObat = ObatDatabase.getAllObat();

        for (Obat obat : daftarObat) {
            if (obat.getNamaObat().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(obat);
            }
        }
        return hasil;
    }

    
    public static Obat cariByKode(String kodeObat) {
        ArrayList<Obat> daftarObat = ObatDatabase.getAllObat();

        for (Obat obat : daftarObat) {
            if (obat.getKodeObat().equalsIgnoreCase(kodeObat)) {
                return obat;
            }
        }
        return null;
    }

    
    public static ArrayList<Obat> cariByKategori(String kategori) {
        ArrayList<Obat> hasil = new ArrayList<>();
        ArrayList<Obat> daftarObat = ObatDatabase.getAllObat();

        for (Obat obat : daftarObat) {
            if (obat.getKategori().toLowerCase().contains(kategori.toLowerCase())) {
                hasil.add(obat);
            }
        }
        return hasil;
    }

    
    public static void tampilkanHasilPencarian(ArrayList<Obat> hasil, String keyword) {

        if (hasil.isEmpty()) {
            System.out.println("\n Tidak ada obat yang ditemukan dengan keyword: \"" + keyword + "\"");
            return;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.println("                          HASIL PENCARIAN: \"" + keyword + "\"");
        System.out.println("=".repeat(100));

        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-12s | %-15s%n",
                "KODE", "NAMA OBAT", "HARGA", "STOK", "EXPIRED", "KATEGORI");

        System.out.println("-".repeat(100));

        for (Obat obat : hasil) {

            String status = "";
            if (obat.isExpired()) {
                status = " [! EXPIRED]";
            } else if (obat.isHampirExpired()) {
                status = " [! HAMPIR EXPIRED]";
            }

            System.out.printf("%-10s | %-25s | Rp %,10.0f | %-10d | %-12s | %-15s%s%n",
                    obat.getKodeObat(),
                    obat.getNamaObat(),
                    obat.getHarga(),
                    obat.getStok(),
                    obat.getTanggalKedaluwarsa(),
                    obat.getKategori(),
                    status);
        }

        System.out.println("=".repeat(100));
        System.out.println("Ditemukan: " + hasil.size() + " obat");
    }

    
    public static void tampilkanDetailObat(Obat obat) {

        if (obat == null) {
            System.out.println("\n Obat tidak ditemukan!");
            return;
        }

        String status;
        if (obat.isExpired()) {
            status = "! EXPIRED!";
        } else if (obat.isHampirExpired()) {
            status = "! HAMPIR EXPIRED!";
        } else {
            status = " AMAN";
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    DETAIL OBAT");
        System.out.println("=".repeat(60));
        System.out.println("Kode Obat          : " + obat.getKodeObat());
        System.out.println("Nama Obat          : " + obat.getNamaObat());
        System.out.println("Harga              : Rp " + String.format("%,d", (int) obat.getHarga()).replace(",", "."));
        System.out.println("Stok               : " + obat.getStok());
        System.out.println("Tanggal Kedaluwarsa: " + obat.getTanggalKedaluwarsa());
        System.out.println("Kategori           : " + obat.getKategori());
        System.out.println("Status             : " + status);
        System.out.println("=".repeat(60));
    }
}

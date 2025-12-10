package service;

import model.Obat;
import database.ObatDatabase;
import java.util.ArrayList;

public class ObatService {
    private ObatDatabase database;

    public ObatService(ObatDatabase database) {
        this.database = database;
    }

    // Tampilkan semua obat
    public void tampilkanSemuaObat() {
        ArrayList<Obat> daftarObat = database.getDaftarObat();

        if (daftarObat.isEmpty()) {
            System.out.println("Tidak ada data obat.");
            return;
        }

        System.out.println("\n=== DAFTAR OBAT ===");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < daftarObat.size(); i++) {
            System.out.println("\nObat ke-" + (i + 1));
            daftarObat.get(i).tampilkanInfo();
            System.out.println("--------------------------------------------------");
        }
    }

    // Tambah obat baru
    public void tambahObat(String kode, String nama, int stok, double harga) {
        Obat obatBaru = new Obat(kode, nama, stok, harga);
        database.tambahObat(obatBaru);
        System.out.println("Obat berhasil ditambahkan!");
    }

    // Cari obat berdasarkan kode
    public void cariObat(String kode) {
        Obat obat = database.cariObatByKode(kode);

        if (obat == null) {
            System.out.println("Obat dengan kode " + kode + " tidak ditemukan.");
        } else {
            System.out.println("\n=== OBAT DITEMUKAN ===");
            obat.tampilkanInfo();
        }
    }

    // Update obat
    public void updateObat(String kode, String namaBaru, int stokBaru, double hargaBaru) {
        Obat obat = database.cariObatByKode(kode);

        if (obat == null) {
            System.out.println("Obat dengan kode " + kode + " tidak ditemukan.");
        } else {
            obat.setNama(namaBaru);
            obat.setStok(stokBaru);
            obat.setHarga(hargaBaru);
            System.out.println("Obat berhasil diupdate!");
        }
    }

    // Hapus obat
    public void hapusObat(String kode) {
        boolean berhasil = database.hapusObat(kode);

        if (berhasil) {
            System.out.println("Obat berhasil dihapus!");
        } else {
            System.out.println("Obat dengan kode " + kode + " tidak ditemukan.");
        }
    }
}

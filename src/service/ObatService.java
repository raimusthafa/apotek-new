package service;

import database.ObatDatabase;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Obat;

public class ObatService {
    private ObatDatabase database;

    public ObatService(ObatDatabase database) {
        this.database = database;
    }

    // tampilkan list semua obat (readd)
    public void tampilkanSemuaObat() {
        ArrayList<Obat> daftarObat = database.getDaftarObat();

        if (daftarObat.isEmpty()) {
            System.out.println("Tidak ada data obat.");
            return;
        }

        System.out.println("\n=== DAFTAR OBAT ===");
        System.out.printf("%-8s | %-20s | %-6s | %-10s | %-12s | %-10s%n", "Kode", "Nama", "Stok", "Harga", "Kadaluarsa", "Kategori");
        System.out.println("---------|---------------------|-------|-----------|-------------|-----------");

        for (Obat obat : daftarObat) {
            System.out.printf("%-8s | %-20s | %-6d | Rp %-7.1f | %-12s | %-10s%n",
                obat.getKode(),
                obat.getNama().length() > 20 ? obat.getNama().substring(0, 17) + "..." : obat.getNama(),
                obat.getStok(),
                obat.getHarga(),
                obat.gettanggalKadaluwarsa().toString(),
                obat.getKategori());
        }
    }

    // tambah obatt (createe)
    public void tambahObat(
            String kode,
            String nama,
            int stok,
            double harga,
            LocalDate tanggalKadaluwarsa,
            String kategori
    ) {
        Obat obatBaru = new Obat(kode, nama, stok, harga, tanggalKadaluwarsa, kategori);
        database.tambahObat(obatBaru);
        System.out.println("Obat berhasil ditambahkan!");
    }


    // edit obat (updatee)
    public void updateObat(
            String kode,
            String namaBaru,
            int stokBaru,
            double hargaBaru,
            LocalDate tanggalKadaluwarsaBaru,
            String kategoriBaru
    ) {
        Obat obat = database.cariObatByKode(kode);

        if (obat == null) {
            System.out.println("Obat dengan kode " + kode + " tidak ditemukan.");
        } else {
            obat.setNama(namaBaru);
            obat.setStok(stokBaru);
            obat.setHarga(hargaBaru);
            obat.settanggalKadaluwarsa(tanggalKadaluwarsaBaru);
            obat.setKategori(kategoriBaru);
            System.out.println("Obat berhasil diupdate!");
        }
    }

    // hapuss obat (deletee)
    public void hapusObat(String kode) {
        boolean berhasil = database.hapusObat(kode);

        if (berhasil) {
            System.out.println("Obat berhasil dihapus!");
        } else {
            System.out.println("Obat dengan kode " + kode + " tidak ditemukan.");
        }
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

    // Cari obat berdasarkan nama (partial, case-insensitive)
    public void cariObatByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama pencarian tidak boleh kosong.");
            return;
        }

        java.util.ArrayList<Obat> hasil = database.cariObatByNama(nama);

        if (hasil.isEmpty()) {
            System.out.println("Tidak ditemukan obat dengan nama yang mengandung: " + nama);
        } else {
            System.out.println("\n=== HASIL PENCARIAN OBAT (Nama) ===");
            System.out.printf("%-8s | %-20s | %-6s | %-10s | %-12s | %-10s%n", "Kode", "Nama", "Stok", "Harga", "Kadaluarsa", "Kategori");
            System.out.println("---------|---------------------|-------|-----------|-------------|-----------");

            for (Obat obat : hasil) {
                System.out.printf("%-8s | %-20s | %-6d | Rp %-7.1f | %-12s | %-10s%n",
                    obat.getKode(),
                    obat.getNama().length() > 20 ? obat.getNama().substring(0, 17) + "..." : obat.getNama(),
                    obat.getStok(),
                    obat.getHarga(),
                    obat.gettanggalKadaluwarsa().toString(),
                    obat.getKategori());
            }
        }
    }

    // pemesanan obat (order)

    public void pesanObat(String kode, int jumlah) {
        Obat obat = database.cariObatByKode(kode);

        if (obat == null) {
            System.out.println("[X] Obat dengan kode " + kode + " tidak ditemukan!");
            return;
        }

        if (obat.isExpired()) {
            System.out.println("[X] Obat sudah expired! Tidak dapat dipesan.");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("[X] Jumlah pemesanan harus lebih dari 0!");
            return;
        }

        if (obat.getStok() < jumlah) {
            System.out.println("[X] Stok tidak cukup! Stok tersedia: " + obat.getStok());
            return;
        }

        // Proses pemesanan
        double totalHarga = obat.getHarga() * jumlah;
        obat.kurangiStok(jumlah);

        // Tampilkan struk
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    STRUK PEMESANAN OBAT");
        System.out.println("=".repeat(60));
        System.out.println("Kode Obat       : " + obat.getKode());
        System.out.println("Nama Obat       : " + obat.getNama());
        System.out.println("Harga Satuan    : Rp " + String.format("%,d", (int) obat.getHarga()));
        System.out.println("Jumlah Beli     : " + jumlah);
        System.out.println("-".repeat(60));
        System.out.println("TOTAL HARGA     : Rp " + String.format("%,d", (int) totalHarga));
        System.out.println("=".repeat(60));
        System.out.println("Sisa Stok       : " + obat.getStok());
        System.out.println("=".repeat(60));

        if (obat.isHampirExpired()) {
            System.out.println("[!] PERHATIAN: Obat ini akan expired pada " + obat.gettanggalKadaluwarsa());
        }

        System.out.println("\n[OK] Pemesanan berhasil!");
    }
}
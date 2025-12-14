package model;

import java.time.LocalDate;

public class Obat {

    private String kode;
    private String nama;
    private int stok;
    private double harga;
    private LocalDate tanggalKadaluwarsa;
    private String kategori;

    // Constructor
    public Obat(
            String kode,
            String nama,
            int stok,
            double harga,
            LocalDate tanggalKadaluwarsa,
            String kategori
            ){
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.tanggalKadaluwarsa = tanggalKadaluwarsa;
        this.kategori = kategori;
    }

    // Getter dan Setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public LocalDate gettanggalKadaluwarsa() {
        return tanggalKadaluwarsa;
    }

    public void settanggalKadaluwarsa(LocalDate tanggalKadaluwarsa) {
        this.tanggalKadaluwarsa = tanggalKadaluwarsa;
    }
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

        public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        }
        return false;
    }


        // Method untuk cek apakah obat hampir expired (kurang dari 30 hari)
    public boolean isHampirExpired() {
        LocalDate sekarang = LocalDate.now();
        LocalDate batasExpired = sekarang.plusDays(30);
        return tanggalKadaluwarsa.isBefore(batasExpired) || tanggalKadaluwarsa.isEqual(batasExpired);
    }

    // Method untuk cek apakah obat sudah expired
    public boolean isExpired() {
        return tanggalKadaluwarsa.isBefore(LocalDate.now());
    }


    // Method untuk menampilkan info obat
    public void tampilkanInfo() {
        System.out.println("Kode  : " + kode);
        System.out.println("Nama  : " + nama);
        System.out.println("Stok  : " + stok);
        System.out.println("Harga : Rp " + harga);
        System.out.println("Tanggal Kadaluwarsa: " + tanggalKadaluwarsa);
        System.out.println("Kategori: " + kategori);
    }
}

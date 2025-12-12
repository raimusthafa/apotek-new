package ui;

import java.util.Scanner;
import service.ObatService;

public class MenuUtama {
    private ObatService obatService;
    private Scanner scanner;

    public MenuUtama(ObatService obatService) {
        this.obatService = obatService;
        this.scanner = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        int pilihan = 0;

        while (pilihan != 6) {
            System.out.println("\n========================================");
            System.out.println("   SISTEM MANAJEMEN APOTEK SEDERHANA");
            System.out.println("========================================");
            System.out.println("1. Tampilkan Semua Obat");
            System.out.println("2. Tambah Obat Baru");
            System.out.println("3. Cari Obat");
            System.out.println("4. Update Obat");
            System.out.println("5. Hapus Obat");
            System.out.println("6. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu (1-6): ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    obatService.tampilkanSemuaObat();
                    break;
                case 2:
                    tambahObatBaru();
                    break;
                case 3:
                    // Gabungkan opsi pencarian: tanya metode (1=Nama, 2=Kode)
                    System.out.println("\n=== PENCARIAN OBAT ===");
                    System.out.println("1. Berdasarkan Nama");
                    System.out.println("2. Berdasarkan Kode");
                    System.out.print("Pilih metode (1-2): ");
                    int metode = -1;
                    try {
                        metode = scanner.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Input tidak valid.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // buang newline

                    if (metode == 1) {
                        cariObatByNama();
                    } else if (metode == 2) {
                        cariObat();
                    } else {
                        System.out.println("Pilihan metode tidak valid.");
                    }
                    break;
                case 4:
                    updateObat();
                    break;
                case 5:
                    hapusObat();
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tambahObatBaru() {
        System.out.println("\n=== TAMBAH OBAT BARU ===");
        System.out.print("Kode Obat: ");
        String kode = scanner.nextLine();

        System.out.print("Nama Obat: ");
        String nama = scanner.nextLine();

        System.out.print("Stok: ");
        int stok = scanner.nextInt();

        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Buang newline

        obatService.tambahObat(kode, nama, stok, harga);
    }

    private void cariObat() {
        System.out.println("\n=== CARI OBAT ===");
        System.out.print("Masukkan kode obat: ");
        String kode = scanner.nextLine();

        obatService.cariObat(kode);
    }

    private void cariObatByNama() {
        System.out.println("\n=== CARI OBAT BERDASARKAN NAMA ===");
        System.out.print("Masukkan nama atau bagian nama obat: ");
        String nama = scanner.nextLine().trim();

        if (nama.isEmpty()) {
            System.out.println("Input kosong. Silakan masukkan nama obat untuk mencari.");
            return;
        }

        obatService.cariObatByNama(nama);
    }

    private void updateObat() {
        System.out.println("\n=== UPDATE OBAT ===");
        System.out.print("Kode Obat yang akan diupdate: ");
        String kode = scanner.nextLine();

        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();

        System.out.print("Stok Baru: ");
        int stok = scanner.nextInt();

        System.out.print("Harga Baru: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Buang newline

        obatService.updateObat(kode, nama, stok, harga);
    }

    private void hapusObat() {
        System.out.println("\n=== HAPUS OBAT ===");
        System.out.print("Masukkan kode obat yang akan dihapus: ");
        String kode = scanner.nextLine();

        obatService.hapusObat(kode);
    }
}

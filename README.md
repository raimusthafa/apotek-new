# Sistem Manajemen Apotek Sederhana (Level Pemula)

Aplikasi CLI sederhana untuk mengelola data obat di apotek.

## Fitur

1. **Tampilkan Semua Obat** - Melihat daftar semua obat
2. **Tambah Obat Baru** - Menambahkan obat baru ke database
3. **Cari Obat (Kode/Nama)** - Mencari obat berdasarkan kode atau nama (mendukung pencarian sebagian nama)
4. **Update Obat** - Mengupdate informasi obat
5. **Hapus Obat** - Menghapus obat dari database

## Struktur Folder

```
apotek2/
├── src/
│   ├── App.java              # Main class
│   ├── model/
│   │   └── Obat.java         # Class model Obat
│   ├── database/
│   │   └── ObatDatabase.java # Database sederhana (ArrayList)
│   ├── service/
│   │   └── ObatService.java  # Service untuk CRUD
│   └── ui/
│       └── MenuUtama.java    # Menu CLI
├── compile.bat               # Compile saja
├── run.bat                   # Run saja
└── compile-and-run.bat       # Compile + Run
```

## Cara Menjalankan

> 📖 **Untuk panduan lengkap dengan penjelasan detail, baca [CARA-PAKAI.md](CARA-PAKAI.md)**

### Langkah 1: Buka Command Prompt / Terminal
- Tekan `Win + R`, ketik `cmd`, Enter
- Atau buka Terminal di VS Code

### Langkah 2: Masuk ke Folder Proyek
```bash
cd d:\TELYUU\tubes\apotek2
```

### Langkah 3: Compile Semua File Java
```bash
javac -d . src\App.java src\model\Obat.java src\database\ObatDatabase.java src\service\ObatService.java src\ui\MenuUtama.java
```

**Penjelasan:**
- `javac` = Java compiler
- `-d .` = Simpan hasil compile di folder saat ini
- Setelah itu list semua file .java yang mau di-compile

### Langkah 4: Jalankan Program
```bash
java App
```

**Penjelasan:**
- `java` = Jalankan program Java
- `App` = Nama class yang punya method main()

### Cara Cepat (Satu Baris)
```bash
javac -d . src\App.java src\model\Obat.java src\database\ObatDatabase.java src\service\ObatService.java src\ui\MenuUtama.java && java App
```

**Catatan:** File .bat yang ada di folder bisa diabaikan, itu hanya shortcut otomatis saja.

## Data Awal

Aplikasi sudah memiliki 3 data obat awal:
- OBT001 - Paracetamol (Stok: 100, Harga: Rp 5000)
- OBT002 - Amoxicillin (Stok: 50, Harga: Rp 15000)
- OBT003 - Vitamin C (Stok: 200, Harga: Rp 3000)

## Catatan untuk Improvement

Ini adalah versi MINIMAL untuk pembelajaran. Anda bisa improve dengan:

1. **Validasi Input** - Tambahkan validasi untuk input user
2. **Exception Handling** - Tambahkan try-catch untuk error handling
3. **Sorting** - Tambahkan fitur sorting berdasarkan nama/harga
4. **Searching** - Pencarian berdasarkan nama sudah didukung (partial, case-insensitive)
5. **File Persistence** - Simpan data ke file agar tidak hilang saat program ditutup
6. **Laporan** - Tambahkan fitur laporan stok, dll
7. **Transaksi** - Tambahkan fitur transaksi penjualan

## Teknologi

- Java (Console Application)
- ArrayList untuk penyimpanan data
- Scanner untuk input user

---
**Level**: Pemula
**Tujuan**: Pembelajaran dasar OOP dan CRUD di Java

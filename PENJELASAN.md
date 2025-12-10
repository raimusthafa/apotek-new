# Penjelasan Kode - Apotek Sederhana

## Konsep Dasar

### 1. Model (Obat.java)
- **Apa itu?** Class yang merepresentasikan data obat
- **Isi:** Atribut (kode, nama, stok, harga) + Getter/Setter
- **Kenapa?** Untuk menyimpan informasi satu obat

```java
Obat obat1 = new Obat("OBT001", "Paracetamol", 100, 5000);
```

### 2. Database (ObatDatabase.java)
- **Apa itu?** Tempat menyimpan semua data obat
- **Isi:** ArrayList<Obat> + method untuk akses data
- **Kenapa?** Untuk menyimpan banyak obat dalam satu tempat

```java
ArrayList<Obat> daftarObat = new ArrayList<>();
```

### 3. Service (ObatService.java)
- **Apa itu?** Logic bisnis untuk operasi CRUD
- **Isi:** Method untuk tambah, cari, update, hapus obat
- **Kenapa?** Memisahkan logic dari UI

### 4. UI (MenuUtama.java)
- **Apa itu?** Tampilan menu untuk user
- **Isi:** Menu pilihan + input dari user
- **Kenapa?** Untuk interaksi dengan user

### 5. Main (App.java)
- **Apa itu?** Entry point aplikasi
- **Isi:** Inisialisasi semua komponen
- **Kenapa?** Titik awal program berjalan

## Alur Program

```
1. User jalankan App.java
2. App.java buat database, service, dan menu
3. Menu tampilkan pilihan ke user
4. User pilih menu
5. Menu panggil service
6. Service akses database
7. Database return data
8. Service proses data
9. Menu tampilkan hasil ke user
10. Kembali ke step 3
```

## Konsep OOP yang Dipakai

1. **Encapsulation** - Data di class Obat dibuat private, akses lewat getter/setter
2. **Separation of Concerns** - Setiap class punya tanggung jawab sendiri
3. **Constructor** - Untuk inisialisasi object
4. **ArrayList** - Untuk menyimpan banyak object

## Tips Belajar

1. Pahami dulu alur program dari App.java
2. Lihat bagaimana data mengalir dari UI -> Service -> Database
3. Coba modifikasi satu-satu:
   - Tambah atribut baru di Obat
   - Tambah method baru di Service
   - Tambah menu baru di UI
4. Jangan takut error, itu bagian dari belajar!

## Perbedaan dengan Apotek (versi kompleks)

| Fitur | Apotek2 (Sederhana) | Apotek (Kompleks) |
|-------|---------------------|-------------------|
| Database | ArrayList biasa | ArrayList dengan fitur advanced |
| Sorting | Tidak ada | Ada (berbagai algoritma) |
| Searching | Cari by kode saja | Cari by berbagai field |
| Validasi | Minimal | Lengkap |
| Error Handling | Minimal | Lengkap dengan try-catch |
| UI | Menu sederhana | Menu dengan formatting bagus |
| Code Structure | Simple | Lebih terstruktur |

## Next Steps untuk Improvement

1. **Tambah Validasi**
   ```java
   if (stok < 0) {
       System.out.println("Stok tidak boleh negatif!");
       return;
   }
   ```

2. **Tambah Exception Handling**
   ```java
   try {
       int pilihan = scanner.nextInt();
   } catch (InputMismatchException e) {
       System.out.println("Input harus angka!");
   }
   ```

3. **Tambah Sorting**
   ```java
   Collections.sort(daftarObat, (o1, o2) -> o1.getNama().compareTo(o2.getNama()));
   ```

4. **Simpan ke File**
   ```java
   // Gunakan FileWriter untuk save data
   // Gunakan FileReader untuk load data
   ```

Selamat belajar! 🚀

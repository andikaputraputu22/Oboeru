# Oboeru - Japanese Learning App (Android Source Code)

### **Deskripsi Aplikasi**
Oboeru adalah aplikasi Android yang dirancang untuk membantu pengguna mempelajari dasar-dasar bahasa Jepang, khususnya Hiragana dan Katakana, melalui metode pembelajaran interaktif dan quiz. Aplikasi ini menekankan pembelajaran yang sederhana, konsisten, dan efektif untuk pemula.

### **✨ Fitur Utama**
- 🔤 **Hiragana Learning**: Belajar huruf Hiragana dengan tampilan yang jelas dan mudah dipahami
- 🔡 **Katakana Learning**: Materi lengkap Katakana untuk pemula
- 🧠 **Quiz Interaktif**: Tebak huruf (Hiragana/Katakana) dan Romaji
- 🔔 **Daily Quiz Reminder**: Notifikasi harian untuk latihan rutin
- ⚙️ **Background Worker**: Menggunakan CoroutineWorker untuk scheduling quiz harian
- 📱 **Simple UI**: Desain minimalis dan fokus pada pengalaman belajar

### **📋 Persyaratan Sistem**
- **Android Studio**: Hedgehog (2023.1.1) atau lebih baru
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 36
- **Compile SDK**: 36
- **Gradle**: 8.0+
- **Kotlin**: dengan Coroutines & KAPT
- **Java**: 11

### **🧱 Tech Highlights**
- ✅ Jetpack Compose (Modern UI Toolkit)
- ✅ Material Design 3
- ✅ MVVM Architecture
- ✅ Hilt Dependency Injection
- ✅ WorkManager (CoroutineWorker)
- ✅ Notification

### **🚀 Cara Setup & Instalasi**

#### **1. Konfigurasi Project**
1. Extract file source code
2. Buka project di Android Studio
3. Sync project dengan Gradle

#### **2. Build & Run**
1. **Clean project**: `Build → Clean Project`
2. **Rebuild project**: `Build → Rebuild Project`
3. **Run aplikasi** di emulator atau device fisik

### **🔧 Troubleshooting**

#### **Notifikasi Tidak Muncul**
- ✅ Pastikan permission notifikasi sudah diizinkan
- ✅ Cek apakah WorkManager berjalan dengan benar
- ✅ Pastikan device tidak membatasi background process

#### **Quiz Tidak Update/Tidak Muncul**
- ✅ Periksa log WorkManager
- ✅ Pastikan CoroutineWorker berhasil dijalankan
- ✅ Restart aplikasi atau device jika diperlukan

#### **Aplikasi Crash**
- ✅ Periksa Logcat di Android Studio
- ✅ Pastikan semua dependency sudah ter-sync
- ✅ Pastikan Min SDK sesuai dengan device

### **📄 Lisensi & Ketentuan**
- ✅ Source code dapat digunakan untuk keperluan pembelajaran & komersial
- ❌ Tidak diperbolehkan mendistribusikan ulang source code tanpa izin
- ⚠️ Credit developer tidak boleh dihapus

### **🛠️ Support & Bantuan**
Jika Anda mengalami kesulitan dalam setup, kustomisasi, atau ingin menambah fitur baru, silakan hubungi:

> **📱 WhatsApp: 081339891936**

**Layanan yang tersedia:**
- 🔧 Setup & konfigurasi aplikasi
- 🎨 Kustomisasi UI/UX
- ➕ Penambahan fitur baru
- 🐛 Troubleshooting & bug fixing
- 🔄 Maintenance & update

## **📊 API Documentation Reference**
- [📱 Android Developer Guide](https://developer.android.com/guide)

## **🔄 Version History**
- **v1.0.0** - Initial release (Hiragana, Katakana, Quiz, Daily Reminder)
- Contact for updates and new versions

---

> **© 2026 Ananka Creative Studio. All rights reserved**
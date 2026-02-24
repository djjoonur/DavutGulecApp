# Davut Güleç Android Uygulaması

Bu proje, www.davutgulec.com web sitesini WebView kullanarak Android uygulamasına dönüştürür.

## 🚀 Kurulum Adımları

### 1. Android Studio Kur
- https://developer.android.com/studio adresinden Android Studio'yu indir
- Kurulumu tamamla

### 2. Projeyi Aç
- Android Studio'yu aç
- "Open an existing project" seç
- Bu klasörü seç: `DavutGulecApp/`

### 3. Gradle Sync
- Android Studio otomatik olarak Gradle sync yapacak
- Birkaç dakika bekle (ilk seferde internet bağlantısı gerekli)

### 4. Uygulamayı Çalıştır
- Bir Android cihaz bağla veya emülatör başlat
- ▶️ Run butonuna bas (Shift+F10)

## 📁 Proje Yapısı

```
DavutGulecApp/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/davutgulec/app/
│           │   └── MainActivity.java      ← Ana kod dosyası
│           ├── res/
│           │   ├── layout/
│           │   │   └── activity_main.xml  ← Tasarım dosyası
│           │   └── values/
│           │       ├── strings.xml        ← Uygulama adı
│           │       └── styles.xml         ← Tema
│           └── AndroidManifest.xml        ← İzinler ve ayarlar
├── build.gradle
└── settings.gradle
```

## ⚙️ Özelleştirme

### URL Değiştirme
`MainActivity.java` içinde şu satırı bul:
```java
private static final String WEBSITE_URL = "https://www.davutgulec.com";
```
Kendi URL'inle değiştir.

### Uygulama Adı Değiştirme
`res/values/strings.xml` içinde:
```xml
<string name="app_name">Davut Güleç</string>
```

### Uygulama İkonu Değiştirme
- `res/mipmap-hdpi/` klasörüne `ic_launcher.png` ekle
- Farklı çözünürlükler için: mdpi (48x48), hdpi (72x72), xhdpi (96x96), xxhdpi (144x144)

## 📱 Özellikler
- ✅ Web sitesi tam ekran gösterimi
- ✅ JavaScript desteği
- ✅ Yükleme çubuğu (progress bar)
- ✅ Geri tuşu ile sayfa geçmişi
- ✅ Harici linkler tarayıcıda açılır
- ✅ Android 5.0+ (API 21+) desteği

## 📦 APK Oluşturma (Yayınlama için)
1. Android Studio'da: Build → Generate Signed Bundle/APK
2. Bir keystore oluştur (ilk kez)
3. Release APK oluştur
4. APK'yı Google Play'e yükle veya direkt paylaş

## ❓ Sorun Giderme

**"CLEARTEXT communication not permitted" hatası:**
- AndroidManifest.xml'de `android:usesCleartextTraffic="true"` zaten ekli

**Sayfa yüklenmiyor:**
- İnternet izninin ekli olduğunu kontrol et (AndroidManifest.xml'de mevcut)
- Cihazın internet bağlantısını kontrol et

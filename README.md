# LuxCopy 🚀

**Premium Screen Text Copier for Android**

LuxCopy is a modern, elegant, and powerful alternative to Universal Copy.  
Copy text from *any* app (even those that block selection), extract text from images with high-quality OCR, detect entities automatically, and enjoy a luxurious Material You experience.

> Built with Kotlin + Jetpack Compose + Accessibility Service + on-device ML Kit OCR.

---

## ✨ Premium Features (vs Universal Copy)

| Feature | LuxCopy | Universal Copy |
|---------|---------|----------------|
| Modern Material 3 + Dynamic Color | ✅ | Basic |
| Smooth animations & glassmorphism | ✅ | Limited |
| High-accuracy on-device OCR (ML Kit) | ✅ | Basic |
| Multi-language OCR (Arabic, English, Chinese, Japanese, Korean, Hindi...) | ✅ | Limited |
| Smart entity detection (emails, phones, addresses, hashtags, @mentions, URLs) | ✅ | ✅ |
| One-tap actions (Translate, Maps, Share, Search, Call, WhatsApp) | ✅ | ✅ |
| Scroll Mode (multi-page selection) | ✅ | ✅ |
| Harvest Mode (auto-collect entities while browsing) | ✅ | ✅ |
| Clipboard History with search & folders | ✅ | ❌ |
| Floating bubble / Quick Settings Tile | ✅ | Limited |
| Dark / Light / System + AMOLED pure black | ✅ | Basic |
| Custom trigger (notification, tile, volume long-press, gesture) | ✅ | Limited |
| No aggressive ads (clean free version + optional tip) | ✅ | Ads heavy |
| Export history as TXT / JSON | ✅ | ❌ |
| Privacy-first (no data collection) | ✅ | ✅ |

---

## 📱 How it works

1. Enable the **LuxCopy Accessibility Service** (one-time).
2. Open any app (Instagram, YouTube comments, WhatsApp, PDFs, etc.).
3. Trigger LuxCopy (Notification tile / Quick Settings / floating bubble).
4. The app overlays the screen and detects all selectable text + entities.
5. Tap what you want → Copy / Translate / Open in Maps / Share instantly.

**Scanner Mode**: Switch to OCR and extract text from any image or screenshot offline.

---

## 🛠️ Project Structure

```
LuxCopy/
├── app/
│   ├── src/main/
│   │   ├── java/com/luxcopy/app/
│   │   │   ├── service/LuxAccessibilityService.kt
│   │   │   ├── ui/ (Compose screens)
│   │   │   ├── overlay/CopyOverlay.kt
│   │   │   ├── ocr/OcrHelper.kt
│   │   │   └── MainActivity.kt
│   │   ├── res/
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 📝 How to Build the APK (Required)

This repository contains the full source code.  
Because of Android security restrictions, you must build the APK yourself:

### Requirements
- Android Studio Ladybug or newer (2024+)
- JDK 17+
- Android SDK 34+

### Steps
1. Clone the repo:
   ```bash
   git clone https://github.com/uneu2bb/LuxCopy.git
   ```
2. Open the project in **Android Studio**.
3. Wait for Gradle sync.
4. Go to **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
5. The APK will be in `app/build/outputs/apk/debug/` or `release/`.

For a release (signed) APK:
- Create a keystore
- Configure `signingConfigs` in `app/build.gradle.kts`
- Build → Generate Signed Bundle / APK

---

## 🔒 Privacy

- Uses only the official **Accessibility Service** API.
- No internet permission required for core features (OCR is on-device).
- No analytics, no tracking, no data collection.
- All processing stays on your device.

---

## 💻 Current Status

- [x] Project structure
- [x] Accessibility Service skeleton
- [x] Modern Compose UI foundation
- [x] Entity detection helpers
- [ ] Full overlay selection UI (in progress)
- [ ] ML Kit OCR integration
- [ ] Clipboard history
- [ ] Floating bubble
- [ ] Quick Settings Tile

---

## 👋 Contribution

Feel free to open issues or pull requests.  
This is a community-friendly premium open-source alternative.

---

**Made with ❤️ for power users who hate restricted copy-paste.**

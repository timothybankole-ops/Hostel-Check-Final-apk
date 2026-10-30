# HostelCheck EKSU — Android APK

The Flutter frontend is configured as an Android app with the display name **HostelCheck EKSU**, application ID `com.hostelcheck.eksu`, and internet access for backend API requests.

## Build the APK automatically (recommended)

1. Extract this ZIP.
2. Create a GitHub repository and upload the **contents of the `HostelCheck_EKSU` folder** to its root (including the `.github` folder).
3. Push to the `main` or `master` branch. The included GitHub Actions workflow will start automatically. You can also open **Actions → Build HostelCheck EKSU Android APK → Run workflow**.
4. When the workflow succeeds, open its run and download the artifact named **HostelCheck-EKSU-Android-APK**. It contains `app-release.apk`.

## Build locally

Install Flutter stable, Android Studio / Android SDK, and Java 17. Then open a terminal in `hostelcheck-eksu/hostelcheck-eksu` and run:

```bash
flutter pub get
flutter build apk --release --dart-define=API_BASE_URL=https://hostelcheck-backend.onrender.com
```

The APK is created at:

`build/app/outputs/flutter-apk/app-release.apk`

## Backend connection

The APK build is configured to use `https://hostelcheck-backend.onrender.com`. The backend must be deployed and reachable for features that require server data.

## Build status

This package is Android-build configured, but an APK has **not** been compiled in this environment because Flutter and the Android SDK are not installed here and external downloads are unavailable. The included GitHub Actions workflow performs the actual APK build in a Flutter-enabled runner.

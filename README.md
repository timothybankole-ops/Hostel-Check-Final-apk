# HostelCheck EKSU — deployment package

This package contains the Flutter web/mobile client and Spring Boot + PostgreSQL API. The existing burgundy, cream and gold design is retained. Payment processing is intentionally disabled and excluded from the current product workflow.

## Deploy on Render

1. Push the contents of this folder to a GitHub repository (keep `render.yaml` at the repository root).
2. In Render, choose **New → Blueprint**, connect that repository, and apply the blueprint. If your Render workspace already has a service named `hostelcheck-backend`, update that existing service to this repository with root directory `hostelcheck-backend` rather than creating a duplicate. Keep its public hostname unchanged so the Flutter app points to the right API.
3. When prompted for `ADMIN_API_KEY`, enter a long random secret and store it safely. Do not put this key in the Flutter app or commit it to Git.
4. Render creates the PostgreSQL database, backend API and Flutter web service. Allow the first builds to finish. The Blueprint uses Render free resources; free PostgreSQL databases are temporary and have a limited lifetime, so move to a paid database and configure backups before storing important live records.
5. Test `https://hostelcheck-backend.onrender.com/api/health` and then open the frontend service URL shown by Render.

The frontend currently compiles its API base URL as `https://hostelcheck-backend.onrender.com`. If you use a different backend service name, update the API URL in both the frontend Dockerfile and `web/admin.html`, then rebuild the frontend.

## Local backend configuration

Set the variables in `.env.example` in your shell or IDE, create a PostgreSQL database, then run `mvn spring-boot:run` from `hostelcheck-backend`. Java 21 and Maven 3.9+ are required.

## Flutter client

From `hostelcheck-eksu/hostelcheck-eksu`, run `flutter pub get`, then `flutter run` for Android or `flutter build apk --release` to create an Android APK. For a local web build, use `flutter build web --release --dart-define=API_BASE_URL=http://localhost:8080`.

## Current features wired to the API

- Student and house-agent registration and login; passwords are PBKDF2-hashed and account records persist in PostgreSQL.
- Public property feed shows approved live listings. Demo listings remain clearly labelled and are never presented as verified.
- House agents can submit property listings for moderation.
- Signed-in students can submit inspection requests for live property listings and report suspicious listings.
- Admin dashboard is available at `/admin` on the frontend service. It supports overview counts, pending property approval/rejection, agent identity verification decisions, inspection status updates and fraud report review. Admin routes require `X-Admin-Key`.

## Important production notes

- `ADMIN_API_KEY` is required before admin endpoints can be used. Keep it private.
- Property photos are currently accepted as comma-separated image URLs in the API; there is no managed image-storage integration in this release. Profile-photo selection is a visual placeholder and profile photos are not uploaded or persisted yet.
- Agent identity verification is an administrative decision field; document/image collection and automated identity checks are not included.
- Demo listings are static sample content only. Replace them with approved, real property submissions before public launch.
- Payments remain disabled. Existing Interswitch source files are retained but only activate under the `payments` Spring profile, which this blueprint does not enable.
- The frontend session token is held in memory; users sign in again after a full app restart.
- Run security review, backups, privacy policy and operational checks before handling real users.

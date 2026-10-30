# HostelCheck API reference

Base URL: `https://hostelcheck-backend.onrender.com`

All request/response bodies use JSON. Authenticated endpoints require `X-Auth-Token: <token>`. Admin endpoints require `X-Admin-Key: <ADMIN_API_KEY>`.

| Method | Endpoint | Purpose | Access |
|---|---|---|---|
| GET | `/api/health` | Service health | Public |
| POST | `/api/auth/register` | Register student or house agent | Public |
| POST | `/api/auth/login` | Sign in | Public |
| GET | `/api/auth/me` | Current account | User token |
| POST | `/api/auth/logout` | Invalidate current token | User token |
| GET | `/api/properties` | Approved property feed | Public |
| GET | `/api/properties/{id}` | Approved property detail | Public |
| GET | `/api/agent/properties` | Agent's submissions | Agent token |
| POST | `/api/agent/properties` | Submit a listing (starts PENDING) | Agent token |
| POST | `/api/inspections` | Request an inspection for approved listing | Student token |
| GET | `/api/my/inspections` | Student inspection history | Student token |
| POST | `/api/fraud-reports` | Submit a fraud/safety report | User token |
| GET | `/api/admin/overview` | Dashboard counts | Admin key |
| GET | `/api/admin/properties/pending` | Pending listing queue | Admin key |
| PATCH | `/api/admin/properties/{id}/decision` | Approve/reject listing (`decision`: `APPROVED` or `REJECTED`) | Admin key |
| GET | `/api/admin/agents/pending` | Agents awaiting identity decision | Admin key |
| PATCH | `/api/admin/agents/{id}/verification` | Set `{ "verified": true/false }` | Admin key |
| GET | `/api/admin/inspections` | All inspection requests | Admin key |
| PATCH | `/api/admin/inspections/{id}/status` | Set `PENDING`, `ACCEPTED`, `DECLINED`, or `COMPLETED` | Admin key |
| GET | `/api/admin/fraud-reports` | Fraud report queue | Admin key |
| PATCH | `/api/admin/fraud-reports/{id}/status` | Set `OPEN`, `INVESTIGATING`, or `RESOLVED` | Admin key |

Registration JSON example:

```json
{
  "name": "Student Name",
  "email": "student@example.com",
  "phone": "08000000000",
  "role": "Student",
  "password": "a-strong-password",
  "institution": "Ekiti State University",
  "matricNumber": "...",
  "department": "...",
  "level": "200 Level"
}
```

Agent registration uses `role: "House Agent"` and requires `businessName`, `businessAddress`, `operatingArea`, and `businessDescription`.

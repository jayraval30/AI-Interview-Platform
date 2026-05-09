# AI Interview Platform

A full-stack AI-powered mock interview platform built using Spring Boot, React, PostgreSQL, JWT Authentication, and WebSocket communication.

---

## Features

* JWT Authentication & Authorization
* AI-Based Mock Interviews
* Real-time Communication
* Role-Based Interview Questions
* Responsive User Interface
* Secure Backend APIs
* PostgreSQL Database Integration
* WebSocket Support

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* PostgreSQL
* Maven
* WebSocket

### Frontend

* React
* Vite
* Axios
* Tailwind CSS

---

## Project Structure

```text
Ai-interview-platform/
│
├── Frontend/
│   └── interview-frontend/
│       ├── src/
│       ├── public/
│       ├── package.json
│       └── vite.config.js
│
├── src/
│   └── main/
│       ├── java/
│       └── resources/
│
├── screenshots/
├── docs/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

---

## Installation

### Backend Setup

```bash
mvn spring-boot:run
```

### Frontend Setup

```bash
cd Frontend/interview-frontend
npm install
npm run dev
```

---

## Environment Variables

Create your local configuration file and add:

```env
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
JWT_SECRET=your_jwt_secret
GROQ_API_KEY=your_groq_api_key
```

---

## Future Improvements

* AI Voice Interview Support
* Resume Analysis
* Performance Analytics
* Leaderboard System
* Video Interview Feature
* Interview Feedback Reports

---

## Author

Het Jani

---

## License

This project is licensed under the MIT License.

# 👗 Clothing Store E-commerce

Welcome to the **Clothing Store E-commerce** project! This is a modern, full-stack e-commerce platform designed for a clothing store, featuring a robust backend, a sleek frontend, and seamless payment integration. Whether you're an admin managing products or a user shopping for the latest fashion, this app has you covered! 🚀

![Clothing Store Demo](https://via.placeholder.com/800x400.png?text=Clothing+Store+Demo) <!-- Replace with actual demo image -->

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-18-blue)](https://reactjs.org/)
[![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-green)](https://www.mongodb.com/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue)](https://www.docker.com/)
[![Stripe](https://img.shields.io/badge/Stripe-Payments-purple)](https://stripe.com/)
[![TypeScript](https://img.shields.io/badge/TypeScript-5-blue)](https://www.typescriptlang.org/)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-3.4-cyan)](https://tailwindcss.com/)

---

## ✨ Features

- **User-Friendly Shopping** 🛍️

  - Browse and purchase clothing items with a responsive React frontend.
  - Secure JWT-based authentication for users (`ROLE_USER`).
  - Place orders with automatic total calculation.

- **Admin Dashboard** 🛠️

  - Manage products (CRUD operations) with `ROLE_ADMIN` access.
  - View and update order statuses (e.g., `PENDING`, `COMPLETED`).

- **Secure Payments** 💳

  - Integrated Stripe for seamless and secure payment processing.

- **Role-Based Access** 🔒

  - Admin-only endpoints (`/api/products`) and user-only endpoints (`/api/orders`).
  - JWT authentication ensures secure API access.

- **Containerized Deployment** 🐳

  - Dockerized backend and MongoDB for easy setup and scalability.
  - Environment variables for secure configuration (e.g., MongoDB URI, Stripe key).

- **Modern Tech Stack** 💻
  - **Backend**: Spring Boot 3.2.0, MongoDB, JJWT for authentication.
  - **Frontend**: React 18, TypeScript, Tailwind CSS, RTK Query for API management.

---

## 🛠️ Project Structure

```
clothing-store-ecommerce/
├── backend/                    # Spring Boot backend with MongoDB
├── frontend/                   # React frontend with TypeScript, Tailwind CSS, RTK Query
├── docker-compose.yml          # Docker configuration for containerization
├── .env                        # Environment variables (not tracked by Git)
├── .gitignore                  # Git ignore file
├── README.md                   # Project documentation
```

---

## 🚀 Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

Ensure you have the following installed:

- ☕ **Java 17** ([Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))
- 🌐 **Node.js 18+** ([Download](https://nodejs.org/))
- 🍃 **MongoDB** (local or Atlas, configured in `.env`)
- 🐳 **Docker** ([Download](https://www.docker.com/get-started))
- 📦 **Git** ([Download](https://git-scm.com/))
- 💳 **Stripe Account** (for payment integration, get API keys from [Stripe Dashboard](https://dashboard.stripe.com/))

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/SansikaDev/clothing-store-ecommerce
   cd clothing-store-ecommerce
   ```

2. **Set Up Environment Variables**:

   - Copy the example environment file:
     ```bash
     cp backend/src/main/resources/application.properties.example backend/src/main/resources/application.properties
     cp docker-compose.yml.example docker-compose.yml
     ```
   - Create a `.env` file in the project root:
     ```bash
     touch .env
     ```
   - Add the following to `.env` (replace with your values):
     ```plaintext
     MONGO_URI=mongodb+srv://<username>:<password>@<cluster>.mongodb.net/clothingstore?retryWrites=true&w=majority&appName=e-commerce
     STRIPE_API_KEY=<your_stripe_secret_key>
     JWT_SECRET=<your_jwt_secret>
     ```

3. **Backend Setup**:

   - Navigate to the backend directory:
     ```bash
     cd backend
     ```
   - Build the Spring Boot application:
     ```bash
     mvn clean install -DskipTests
     ```
   - Refer to `backend/README.md` for additional backend-specific instructions.

4. **Frontend Setup**:

   - Navigate to the frontend directory:
     ```bash
     cd ../frontend
     ```
   - Install dependencies:
     ```bash
     npm install
     ```
   - Refer to `frontend/README.md` for additional frontend-specific instructions.

5. **Run with Docker**:

   - From the project root, start the application:
     ```bash
     docker-compose up --build
     ```
   - The backend will run on `http://localhost:8080`, and the frontend will be accessible (port depends on frontend config).

6. **Access the Application**:
   - **Backend APIs**: `http://localhost:8080/api/auth`, `/api/products`, `/api/orders`
   - **Frontend**: Open the URL specified in `frontend/README.md` (e.g., `http://localhost:3000`).
   - Test APIs using **Thunder Client** or **Postman**:
     - Register: `POST /api/auth/register`
     - Login: `POST /api/auth/login`
     - Create Order: `POST /api/orders` (requires JWT with `ROLE_USER`)

---

## 🧪 Testing

- **Backend Testing**:

  - Use **Thunder Client** in VS Code to test APIs:
    - `POST /api/auth/register`: Create users (`ROLE_USER` or `ROLE_ADMIN`).
    - `POST /api/products`: Add products (requires `ROLE_ADMIN` JWT).
    - `POST /api/orders`: Place orders (requires `ROLE_USER` JWT).
  - Refer to `backend/README.md` for detailed test cases.

- **Frontend Testing**:
  - Run unit tests (if implemented):
    ```bash
    cd frontend
    npm test
    ```

---

## 🤝 Contributing

We welcome contributions! To get started:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/your-feature`.
3. Commit your changes: `git commit -m "Add your feature"`.
4. Push to the branch: `git push origin feature/your-feature`.
5. Open a Pull Request.

Please follow the [Code of Conduct](CODE_OF_CONDUCT.md) and check `CONTRIBUTING.md` for guidelines.

---

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## 📬 Contact

Have questions or feedback? Reach out!

- **GitHub**: [SansikaDev](https://github.com/SansikaDev)
- **Email**: sansika.kodi@gmail.com
- **Issues**: [Open an issue](https://github.com/SansikaDev/clothing-store-ecommerce/issues)

Happy shopping and coding! 🛍️💻

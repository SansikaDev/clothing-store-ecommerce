# Clothing Store Backend

Spring Boot backend for the Clothing Store e-commerce application with MongoDB.

## Setup

1. Ensure MongoDB is running (via Docker, see root `docker-compose.yml`).

2. Install Java 17 and Maven.

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at `http://localhost:8080`.

## Endpoints

- `/api/auth`: User registration and login
- `/api/products`: Manage products (CRUD)
- `/api/orders`: Manage orders
- `/api/cart`: Manage user cart
- `/api/payment`: Process payments (Stripe)

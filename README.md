# Product API

This project is a RESTful API for managing a simple "Product" resource. It is built with Spring Boot and uses an H2 in-memory database. The API provides endpoints for creating, retrieving, updating, and deleting products.

## Endpoints

### 1. Retrieve a List of Products
- **Endpoint:** `GET /products`
- **Description:** Retrieves a list of all products.
- **Success Response:**
  - **Status Code:** `200 OK`
  - **Body:**
    ```json
    [
      {
        "id": 1,
        "name": "Product1",
        "price": 10.0
      },
      {
        "id": 2,
        "name": "Product2",
        "price": 20.0
      }
    ]
    ```

### 2. Retrieve a Single Product by ID
- **Endpoint:** `GET /products/{id}`
- **Description:** Retrieves a product by its ID.
- **Success Response:**
  - **Status Code:** `200 OK`
  - **Body:**
    ```json
    {
      "id": 1,
      "name": "Product1",
      "price": 10.0
    }
    ```
- **Error Response:**
  - **Status Code:** `404 Not Found`
  - **Body:**
    ```json
    {
      "error": "Product not found"
    }
    ```

### 3. Create a New Product
- **Endpoint:** `POST /products`
- **Description:** Creates a new product.
- **Request Body:**
  ```json
  {
    "name": "NewProduct",
    "price": 30.0
  }


## Prerequisites

- Java 17
- Apache Maven 3.8+
- A running MySQL database instance
- A running MongoDb database instance

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/MinhWeebik/spring-boot-code-base.git
    cd my-spring-boot-app
    ```

2.  **Configure the database:**
    -   Create a copy of the example properties file:
        ```bash
        cp src/main/resources/application.properties src/main/resources/application-dev.properties
        cp src/main/resources/application.yml src/main/resources/application-dev.yml
        ```
    -   Edit `src/main/resources/application.yml` and enter your local database username and password.

3.  **Build and run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will start on `http://localhost:8089`.

## API Endpoints

Here are some of the main API endpoints:

| Method | Endpoint                            | Description                     |
|--------|-------------------------------------|---------------------------------|
| `GET`  | `/example/ex/get/(mongo/sql)`       | Retrieves a list of all users. |

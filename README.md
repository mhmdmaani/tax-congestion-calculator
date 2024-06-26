# Tax Congestion Calculator

## Overview

Tax Congestion Calculator is a Java Spring Boot application designed to calculate congestion taxes for vehicles in urban areas. The application integrates Swagger for API documentation and uses H2 Database for data storage.

## Features

- Calculate congestion tax based on vehicle type and time of entry.
- REST ful API for easy integration with other services.
- Interactive API documentation with Swagger UI.
- In-memory H2 database for quick setup and testing.

## Getting Started

### Prerequisites

- Java 22
- Maven 3.6.0 or later


### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/mhmdmaani/tax-congestion-calculator.git
   cd tax-congestion-calculator
    ```
    - Branches:
        - `main`: The main branch support Gothenburg city only.
        - `feat/multiple-cities`: branch supports multiple cities.

2. Build the project:
   ```sh
    mvn clean install

3. Run the application:
4. Run the application:
   ```sh
   mvn spring-boot:run

5. Access the Swagger UI:
   ```
    http://localhost:8080/swagger-ui.html
   ```
6. Test Application:
 I have added some dummy date(seed) in the H2 database to test the application.
- Add new Entrance for car:
  post: http://localhost:8080/entrances
- Calculation End points:
  get: http://localhost:8080/tax/calculate/{carId}  // carId is the id of the car that you want to calculate the tax for it.
- calculate for all cars: http://localhost:8080/tax/calculate/all


     
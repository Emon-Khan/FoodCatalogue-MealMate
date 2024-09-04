# FoodCatalogue - MealMate

## Overview

The **FoodCatalogue** service is a crucial component of the **MealMate** project, designed to manage and display food items for restaurants. This service is built using the Spring Boot framework and operates within a microservices architecture.

## Features

- **CRUD Operations**: Manage food items with create, read, update, and delete functionalities.
- **Eureka Integration**: Registers with Eureka for service discovery.
- **Spring Boot**: Utilizes the Spring Boot framework for robust and scalable application development.
- **MySQL Database**: Stores food item data in a MySQL database.

## Getting Started

### Prerequisites

- **JDK 11** or higher
- **Maven**
- **MySQL Database**
- **Eureka Service** (for service discovery)

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Emon-Khan/FoodCatalogue-MealMate.git

2. **Navigate to the Project Directory**

   ```bash
   cd FoodCatalogue-MealMate

3. **Configure the Database**

   Update the application.properties   file located in src/main/resources with your MySQL database details:

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/food_catalogue

   spring.datasource.username=root

   spring.datasource.password=your_password

4. **Build the Project**

   ```bash
   mvn clean install

5. **Run the application**

   ```bash
   mvn spring-boot:run

## API Endpoints
### Get All Food Items
- URL: /api/food-items
- Method: GET
- Description: Retrieve a list of all food items.
- Response: JSON array of food items.

### Get Food Item by ID
- URL: /api/food-items/{id}
- Method: GET
- Description: Retrieve a specific food item by its ID.
- Response: JSON object of the food item.

### Add New Food Item
- URL: /api/food-items
- Method: POST
- Description: Add a new food item to the catalog.
- Request Body: JSON object with food item details.

```bash
{
  "id": 1,
  "itemName": "Pizza",
  "itemDescription": "Delicious cheese pizza",
  "isVeg": true,
  "price": 9.99,
  "restaurantId": 1
}





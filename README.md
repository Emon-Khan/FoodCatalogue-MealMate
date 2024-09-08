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

- **JDK 17** or higher
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

### Get Food Item by ID
- URL: /api/foodCatalogue/foodCataloguePage/{restaurantId}
- Method: GET
- Description: Retrieve a specific food item by restaurant ID.
- Response: JSON object of the food item.

### Add New Food Item
- URL: /api/foodCatalogue/foodItems
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
### Screenshots
![image](https://github.com/user-attachments/assets/3b5f44d3-f152-48c9-8f13-1dfcb736b11f)

![image](https://github.com/user-attachments/assets/9006f4c7-f109-4eb0-a7ff-2eb7a8a9f027)


## Docker Instructions

If you prefer using Docker for this service, you can pull and run the FoodCatalogue-MealMate image directly from Docker Hub.

### Pulling the Image from Docker Hub

1. To pull the image, use the following command:
    ```bash
    docker pull rkemon94/foodcatalogue-mealmate:latest
    ```

### Running the FoodCatalogue Service with Docker

2. Run the FoodCatalogue service in a Docker container:
    ```bash
    docker run --name foodcatalogue-container -p 9092:9092 rkemon94/foodcatalogue-mealmate:latest
    ```

3. Access the service:

   After running the container, you can access the API on http://localhost:9092.

### Stopping and Removing the Container

- To stop the running container:
    ```bash
    docker stop foodcatalogue-container
    ```

- To remove the container after stopping it:
    ```bash
    docker rm foodcatalogue-container
    ```

## Conclusion

This FoodCatalogue service is designed to handle food item management for restaurants in the MealMate microservices ecosystem. Running it via Docker ensures a smooth deployment process, and it integrates seamlessly with other MealMate services such as the EurekaService.


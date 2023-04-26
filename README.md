**Room Occupancy Management - README**

This project provides a REST API for a hotel room occupancy optimization tool. The tool allows hotel clients to input the number of available Premium and Economy rooms for the night, based on an array of numbers representing the willingness to pay for the night of potential guests. The tool will then allocate the rooms to maximize revenue, following the following rules:

Customers willing to pay 100 EUR or more will be allocated to Premium rooms.
Customers willing to pay less than 100 EUR will be allocated to Economy rooms.
If all Economy rooms are occupied with low paying customers, and there are Premium rooms available, higher paying customers will be allocated to Premium rooms.

**Technologies**

This project is built with the following technologies:

Java 14,
Spring Boot 2.5.7,
Maven 3.0.5,
JUnit 5 for testing,

**Getting Started**

To run this project, you'll need to have Java 14 and Maven 3.0.5 installed on your machine.

Clone this repository to your local machine.
Navigate to the project directory in your terminal/command prompt.
Run the following command to start the application:

_mvn spring-boot:run_

Once the application is running, you can send HTTP requests to the API endpoints.

You can also open and run the project using JETBrains IDE.

**API Endpoints**

Make Reservation

Endpoint: POST /makeReservation

This endpoint allows hotel clients to designate rooms based on the number of available Premium and Economy rooms, and the willingness to pay from potential guests. This is the mock data representing the potential guest willingness to pay: [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209], which has been encapsulated in the project.

Here is an example:


**Request body:**

{
"premiumRooms": 3,
"economyRooms": 3,
}

**Response body:**

{
"premiumOccupied": 3,
"economyOccupied": 3,
"totalEarningsForPremium": 738.0,
"totalEarningsForEconomy": 167.99,
"overallEarningsForTheNight": 905.99
}

**Running Tests**

To run the tests for this project, run the following command in the project directory:

_mvn test_

This will run the tests using JUnit 5.

**Future Improvements**

The tool currently uses a simple greedy algorithm to maximize revenue. A more sophisticated algorithm could be developed to further optimize revenue.
The API could be secured with authentication and authorization to ensure that only authorized hotel clients can access the tool.
Additional endpoints could be added to provide more functionality, such as a way to update the available rooms during the day.


# Queueing System for Customer Service

This is a simple Java-based queueing system designed to handle customer service operations in a company. It uses SQL for data storage and retrieval of customer details.

## Features

- Add customer to the queue.
- View customers in the queue.
- Remove customer from the queue after service is provided.
- Simple integration with a SQL database to manage customer data.

## Technologies Used

- Java
- SQL (MySQL or PostgreSQL)
- JDBC for database connection

## Database Schema

- **customers** table:
  - id (int, primary key)
  - name (varchar)
  - service_status (boolean, false for waiting, true for served)

## Usage

1. Set up the database and import the schema.
2. Run the Java application to interact with the system.

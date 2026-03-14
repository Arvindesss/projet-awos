# ✈️ AWOS Airline Reservation System

Microservices-based airline reservation system built with **Spring Boot** and **Spring Cloud**.

This project was developed as part of the **Service-Oriented Web Architecture (AWOS) course** and demonstrates how to migrate a **monolithic airline reservation system** into a **modern microservices architecture** capable of scaling and supporting future growth.

---

# 🏗️ Architecture

The system follows a **Spring Cloud microservices architecture** where each business capability is implemented as an independent service.

Main components:

- **API Gateway** – entry point for client requests
- **Discovery Service (Eureka)** – service registry and discovery
- **Business Microservices** – domain-specific services
- **External Configuration Server**

Configuration files are stored in a separate repository:

👉 https://github.com/Arvindesss/projet-awos-config

---

# 🧰 Technologies Used

- Java
- Spring Boot
- Spring Cloud
- Spring Data JPA
- REST APIs
- Maven
- H2
- Git

---

# 📦 Microservices

The platform is composed of several services handling different airline operations.

| Service | Description |
|--------|-------------|
| Discovery Service | Registers and discovers services using Eureka |
| API Gateway | Single entry point for all client requests |
| Flight Service | Manages flights and schedules |
| Booking Service | Handles seat reservations |
| Passenger Service | Stores passenger information |
| Check-in Service | Handles passenger check-in |
| Payment Service | Manages payment transactions |
| Notification Service | Sends emails or notifications |

---

# ⚙️ Main Features

### 🔍 Search
Allows users to search for available flights using several filters:
- Price
- Departure and arrival airports
- Date

---

### 🧾 Reservation
Handles the process of creating flight reservations for a customer.

A customer can reserve a seat on a flight.

When a reservation is first created, it has the status **PENDING**, meaning it is waiting for payment to be validated.

Once the payment is completed, the reservation status becomes **CONFIRMED**.

---

### 🛫 FlightAccess
Handles the process of:
- Passenger **check-in**
- **Boarding**
- Automatic **seat assignment** if no seat was selected during the reservation process.

---

### ✈️ Flight
Manages data related to:
- Flights
- Aircraft
- Aircraft seats
- Flight routes (itineraries)

---

### 👤 Customer
Manages customer data.

Each customer is identified by an **identity card**.

---

### 🌍 Location
Manages data related to locations:
- Cities
- Countries
- Airports

---

### 💰 Pricing
Stores the **base price** for an itinerary between two airports.

---

### 💺 Inventory
Each flight has an **inventory** that stores the list of seats and their status:
- Available
- Unavailable

---

### 💳 Payment
Handles payments.

Allows a customer to pay for a reservation that is **waiting for payment**.

---

### 📊 Back-office
Aggregates data from the different services for **accounting and data analysis purposes**.

In this project, it returns a report where:
- a **year can be selected**
- the **monthly revenue** is displayed based on all payments made by customers.

---

# 📂 Diagrams

Detailled diagrams (Class Diagrams, Process Flow, Target Microservice Architecture) are available [here](https://viewer.diagrams.net/?tags=%7B%7D&lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Schema_Microservices_archi.drawio&dark=auto#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1w8MqNSrVBnSfFnAsFujcGYZfLSAX6d8q%26export%3Ddownload) (In French)

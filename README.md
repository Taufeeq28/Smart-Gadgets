# SmartGadgets Online Retailer

## Overview
SmartGadgets is an online retailer that allows customers to place orders for various gadgets through their servlet-based web application. Customers can browse and purchase products from different categories, choose between store pickup or home delivery, and enjoy additional features such as warranty options, discounts, and rebates. The application provides a seamless shopping experience, enabling customers to create accounts, manage orders, and make payments using credit cards.

The SmartGadgets website also includes an administrative interface for the StoreManager, where they can manage products, customer accounts, and sales orders. The StoreManager has access to inventory and sales reports, allowing them to track product availability, sales, and daily transactions.

Additionally, the application features a search auto-completion functionality accessible to all users, providing a convenient way to search for gadgets.

## Features

### Customer Features
- Browse and select gadgets from different categories, including Wearable Technology, Phones, Laptops, and Voice Assistants.
- View gadget details such as name, price, and description, along with associated accessories.
- Create an account online to facilitate future orders.
- Choose between in-store pickup or home delivery for each order.
- Place orders online, track order status, and cancel orders if necessary.
- Make secure credit card payments.
- Benefit from retailer special discounts and manufacturer rebates.
- Add or remove items from the shopping cart within the same session.

### StoreManager Features
- Add, delete, and update gadgets in the data store.
- Create and manage customer accounts.
- Add, delete, and update customer orders.
- Access inventory reports, including a table of available gadgets, a bar chart displaying gadget availability, and listings of gadgets on sale or with manufacturer rebates.
- Generate sales reports, including a table of sold gadgets, a bar chart displaying sales for each gadget, and a table of daily sales transactions.

### Additional Features
- Search auto-completion functionality to assist users in finding gadgets quickly and efficiently.


## Development

The SmartGadgets online retailer application was developed using the following technologies and frameworks:

- Java Servlets: Used for server-side programming and handling HTTP requests.
- Java Server Pages (JSP): Used for dynamic web page generation.
- MySQL: Used as the relational database management system for storing gadget information, customer data, and orders.
- JDBC (Java Database Connectivity): Used for connecting and interacting with the MySQL database.
- HTML/CSS: Used for creating the user interface and styling the web pages.
- JavaScript: Used for client-side validation and enhancing user interactions.
- Bootstrap: Used as a front-end framework for responsive and visually appealing web design.
- Chart.js: Used for generating bar charts to visualize inventory and sales data.
- Ajax: Used for asynchronous communication between the client and server, specifically for the search auto-completion feature.
- Apache Tomcat: Used as the servlet container for deploying and running the application.

## Installation
To set up the SmartGadgets online retailer application, follow these steps:

1. Clone the repository to your local machine.
2. Install a Java Development Kit (JDK) compatible with your chosen servlet container.
3. Install a MySQL database server and create a new database for the application.
4. Import the provided SQL script to create the necessary tables and populate initial data.
5. Configure the database connection settings in the application's configuration files.
6. Build the application using your preferred build tool, such as Apache Maven or Gradle.
7. Deploy the built application to your servlet container (e.g., Apache Tomcat).
8. Start the servlet container and ensure it is running.

## Usage
Once the SmartGadgets application is installed and running, users can access the website through a web browser.

Customers can create accounts, browse gadgets, add them to the shopping cart, and proceed to checkout. They can select the desired delivery option, enter personal and payment information, and receive a confirmation number along with the delivery/pickup date.

The StoreManager can log in to the administrative interface using their credentials. From there, they can manage gadgets, customer accounts, and sales orders. They have access to inventory reports, sales reports, and other administrative functions.

All users can benefit from the search auto-completion feature, which provides real-time suggestions as they type in the search bar, making it easier to find desired gadgets.

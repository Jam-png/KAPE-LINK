# <h1 align="center" style="font-family: Georgia, serif; font-size: 3.5em; font-weight: bold;">☕ JAZ Once: KapeLINK System ☕</h1>

<p align="center">
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Borromeo, Jamaica L.</span><br>
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Monterey, John Zedrick D.</span><br>
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Villavicencio, Aliceson O.</span>
</p>

## 📑 Overview
<a id="overview"></a>

The **KAPE LINK System** is a command-line interface (CLI) application built in **Java**. It is designed to simulate a basic digital marketplace, facilitating the connection between local coffee **Farmers** (producers) and **Buyers** (consumers/retailers) in the Philippine coffee trade.

The project showcases core **Object-Oriented Programming (OOP)** principles using distinct user roles and product classes to manage inventory and user interactions.

---

## 🎯 Key Features
<a id="features"></a>

* **User Authentication:** Simple username/password login for two distinct pre-defined user roles.
* **Role-Based Access:** Separate menu systems for Farmers and Buyers, controlled by **polymorphism**.
* **Product Listing:** Farmers can create new listings by defining the product name, variety, quality, quantity (kg), price (₱), and availability.
* **Market Visibility:** All listed coffee beans are immediately available for Buyers to view.

---

## 💻 OOP Concepts Applied
<a id="oop"></a>

The system's design is heavily reliant on the Four Pillars of OOP:

### 1. Inheritance
The base class **`User` (Abstract)** is extended by the concrete classes **`Farmer`** and **`Buyer`**, allowing them to inherit common properties (name, username, password).


### 2. Polymorphism
The abstract method **`getRole()`** in `User` is overridden in `Farmer` (returns "Farmer") and `Buyer` (returns "Buyer"). The `Main.java` login logic uses the general `User` object reference to call the correct implementation at runtime.

### 3. Encapsulation
Product fields in **`CoffeeBean.java`** are declared **`private final`** (`productName`, `price`, `quantity`, etc.), making them immutable after object creation. User login details are protected/private and accessed only via explicit public methods (`getUsername()`, `getPassword()`).

### 4. Abstraction
The **`User` class is abstract**, defining the necessary interface (`getRole()`) without providing its implementation. This simplifies the client code (`Main.java`), which only needs to know that a user has a role.

---

## 📂 Program Structure
<a id="program-structure"></a>

The project consists of separate Java files:
```
 ├──src
    ├── Main.java         # Application entry point, handles login and menus 
    ├── User.java         # Abstract base class for all users 
    ├── Buyer.java        # Concrete subclass (inherits User, views market) 
    ├── Farmer.java       # Concrete subclass (inherits User, manages product list) 
    └── CoffeeBean.java   # Model class for product listings
 ├──readme
    ├──README.md
```

Data is stored in static lists within `Main.java` for simplicity, representing all users and all products available in the market (`marketProducts`).

---

## 🚀 How To Run
<a id="how-to-run"></a>

This is a standard Java console application.

1.  **Save Files:** Ensure all five Java files are saved in the same directory.
2.  **Compile:** Open your terminal and compile the files:
    ```bash
    javac *.java
    ```
3.  **Run:** Execute the main class:
    ```bash
    java Main
    ```

## 🖥️ Sample Output
<a id="sample-output"></a>

### Farmer Sample Output
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 1
```
Registration of the user (Buyer or Farmer is determined after selecting role).
```
--- User Registration ---
Enter name: Jamaica
Choose username: Jam
Choose password (min 4 characters): JamaicaBorromeo_2006
Contact number (11 digits): 12345678910
Location: Gelerang Kawayan, San Pascual, Batangas
Select role:
1. Buyer
2. Farmer
Enter: 2

Yasss! Registration successful! You can now login.
```
Login of Farmer role:
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 2
```
Next, inputting the username and password the user used for her/his registration:
```
--- Login ---
Username: Jam   
Password: JamaicaBorromeo_2006

Logged in as: Farmer
1. Continue to Menu
2. Delete My Account
3. Logout
Choose: 1
```
Displaying Farmer interface:
```
--- Farmer Menu ---
1. Add Coffee Product
2. View My Products
3. Logout
Choose: 1
Product name: Mr. Bean
Type/Variety: Barako
Quality: Whole beans         
Quantity (kg): 50
Price per kg: 540
Availability: Limited Stocks

? Product added!
```
Logging out:
```
--- Farmer Menu ---
1. Add Coffee Product
2. View My Products
3. Logout
Choose: 3
Logging out...
```
### Buyer Sample Output
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 1
```
Buyer registration:
```
--- User Registration ---
Enter name: Zedrick
Choose username: Zed
Choose password (min 4 characters): JohnZedrick_2004
Contact number (11 digits): 98765432110
Location: Alangilan, Batangas
Select role:
1. Buyer
2. Farmer
Enter: 1

Yasss! Registration successful! You can now login.
```
Logging in as Buyer:
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 2
```
```
--- Login ---
Username: Zed
Password: JohnZedrick_2004

Logged in as: Buyer
1. Continue to Menu
2. Delete My Account
3. Logout
Choose: 1
```
Displaying of listed or available coffee product inputted by the Farmer:
```
--- Buyer Menu ---
1. View Available Coffee Products
2. Logout
Choose: 1
```
```
--- Coffee Products ---
Product: Mr. Bean
Type/Variety: Barako
Quality: Whole beans
Quantity: 50 kg
Price: ?540.0 per kg
Availability: Limited Stocks
--------------------------
```
Logging out as Buyer:
```
--- Buyer Menu ---
1. View Available Coffee Products
2. Logout
Choose: 2
Logging out... ?
```
```
Logged in as: Buyer
1. Continue to Menu
2. Delete My Account
3. Logout
Choose: 3
Logging out...
```
### Deletion of Account (Farmer)
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 2
```
```
--- Login ---
Username: Jam
Password: JamaicaBorromeo_2006

Logged in as: Farmer
1. Continue to Menu
2. Delete My Account
3. Logout
Choose: 2
Are you sure you want to delete your account? (yes/no): yes
? Account deleted successfully.
```
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 2
```
### Deletion of Account (Buyer)
```
--- Login ---
Username: Zed
Password: JohnZedrick_2004

Logged in as: Buyer
1. Continue to Menu
2. Delete My Account
3. Logout
Choose: 2
Are you sure you want to delete your account? (yes/no): yes
? Account deleted successfully.
```
```
«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
       /  /  /
      _________
     |         |---
     |   JAZ   |   |     K A P E ? L I N K
     |_________|---

«««000»»»ooo«««000»»»ooo«««000»»»ooo«««000»»»
1. Register
2. Login
3. Exit
Choose: 3
Goodbye!
```
---

## 👤 Author & Acknowledgement
<a id="acknowledgement"></a>

Developed as a comprehensive educational project demonstrating core OOP principles and CLI application architecture.

### Developers

| Photo | Name | Role |
| :---: | :--- | :--- |
| *[Image Placeholder]* | Borromeo, Jamaica L. | Team Member |
| *[Image Placeholder]* | Monterey, John Zedrick D. | Team Member |
| *[Image Placeholder]* | Villavicencio, Aliceson O. | Team Member |

<p align="center">Enjoy linking with local coffee! ☕✨</p>

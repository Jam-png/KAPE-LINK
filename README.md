# <h1 align="center" style="font-family: Georgia, serif; font-size: 3.5em; font-weight: bold;">☕ JAZ Once: KapeLINK System ☕</h1>

<p align="center">
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Borromeo, Jamaica L.</span><br>
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Monterey, John Zedrick D.</span><br>
  <span style="font-size: 1.1em;font-family: Verdana, sans-serif;">Villavicencio, Aliceson O.</span>
</p>

## 📑 Description/Overview
<a id="overview"></a>

The KAPE LINK System, developed by JAZ Once (Join Agriculture Zest Once), is a Java-based command-line application designed to facilitate direct interaction between local coffee farmers and buyers. The system addresses issues of limited market access and unfair pricing by enabling user registration, product listing, and product browsing within a transparent digital environment. Guided by the principles of Kultura, Ani, Presyo, and Epektibo, it promotes fair trade, farmer empowerment, and efficient information exchange while intentionally excluding payment and logistics to maintain a focused, educational scope.

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

The system's design is heavily reliant on the principles of OOP:

### 1. Inheritance

  a. The **`Buyer`** and **`Farmer`** classes both inherit from the abstract class **`User`**, meaning they automatically receive shared fields like **`name`**, **`username`**, **`password`**, etc.

  b. Inheritance helps avoid duplicate code since all user types share common attributes and behaviors.

  c. It allows specialized user types (**`Buyer`** / **`Farmer`**) to extend the base class with their own unique actions.

### 2. Abstraction
   
  a. The **`User`** class is declared abstract, meaning it cannot be illustrated and serves only as a blueprint.

  b. It includes the abstract method **`getRole()`**, which forces every subclass (**`Buyer`**, **`Farmer`**) to provide its own implementation.

  c. This hides unnecessary details from the **`Main`** program and provides a general structure for all user types.

### 3. Polymorphism

  a. During login, the system treats all users as **`User`** objects, but behaves differently depending on their real type (**`Buyer`** or **`Farmer`**).

  b.  The overridden method **`getRole()`** returns different values depending on which subclass is being used.

  c. The instanceof checks allow the program to determine whether to show the **`Buyer menu`** or **`Farmer menu`** at runtime.

### 4. Encapsulation

  a. User information (**`name`**, **`username`**, **`password`**, etc.) is stored in protected fields, accessible only by the class and its subclasses.

  b. Accessor methods like **`getUsername()`** and **`getPassword()`** control how sensitive data is retrieved, preventing direct manipulation.

  c. Encapsulation helps protect user data and keeps the internal structure hidden from outside classes.

### 5. Exception Handling

  a. Error handling is implemented using input validation, preventing invalid user data from entering the system (e.g., password too short, contact not 11 digits).

  b. The farmer's menu includes parsing of numbers (Integer.parseInt, Double.parseDouble), which are wrapped in controlled prompts to avoid crashes from invalid input.
  
  c. Conditional checks such as verifying username existence or incorrect login credentials ensure the program handles user errors gracefully.

## 🗄️File Handling
This system includes file handling to ensure that user registration data is saved and retained even after the program is closed. Whenever a new user registers, their information—such as username and password — is written to a text file. When the program starts, it reads the file to load previously registered users, allowing login and account management to function without losing data. File handling in this system provides data persistence, making the application more reliable and user-friendly.
  
---

## 📂 Program Structure
<a id="program-structure"></a>

The project consists of separate files:
```
 ├──src
    ├──Main
      ├── Main.java         # Application entry point, handles login and menus
    ├──models
      ├── User.java         # Abstract base class for all users 
      ├── Buyer.java        # Concrete subclass (inherits User, views market) 
      ├── Farmer.java       # Concrete subclass (inherits User, manages product list) 
      └── CoffeeBean.java   # Model class for product listings
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
     |   JAZ   |   |     K A P E  L I N K
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
     |   JAZ   |   |     K A P E  L I N K
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
Displaying Farmer interface and inputting info:
```
--- Farmer Menu ---
1. Add Coffee Product
2. View My Products
3. Logout
Choose: 1
Farmer Name: Jamaica Borromeo
Contact Info: 12345678910
Product name: Mr. Bean
Type/Variety: Barako
Quality: Whole beans         
Quantity (kg): 50
Price per kg: 540
Availability: Limited Stocks

Product added!
```
Viewing Products:
```
--- Your Products ---
Farmer Name: Jamaica Borromeo
Contact Info: 12345678910
Product: BeanJam
Type/Variety: Barako
Quality: Roasted, Strong Aroma
Quantity: 10 kg
Price: 550.0 per kg
Availability: Available
--------------------------
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
     |   JAZ   |   |     K A P E  L I N K
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
     |   JAZ   |   |     K A P E  L I N K
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
Farmer Name: Jamaica Borromeo
Contact Info: 12345678910
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
     |   JAZ   |   |     K A P E  L I N K
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
     |   JAZ   |   |     K A P E  L I N K
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
     |   JAZ   |   |     K A P E  L I N K
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

| Photo | Name | Role |
| :---: | :--- | :--- |
| <img src="images/Borromeo.jpg" width="120"> | Borromeo, Jamaica L. | Team Member |
| <img src="images/Monterey.jpg" width="120"> | Monterey, John Zedrick D. | Team Member |
| <img src="images/Villavicencio.jpg" width="120"> | Villavicencio, Aliceson O. | Team Member |

<div style="page-break-before: always;"></div>
<h2>Acknowledgement</h2>
<p>
    We would like to express our sincere gratitude to our professor, <strong>Mr. Emmanuel Charlie Enriquez</strong>, for the guidance, support, and encouragement 
    provided throughout the development of this project. Your insights and feedback  greatly contributed to the improvement and completion of this work.
</p>

<p align="center">Enjoy linking with local coffee! ☕✨</p>

---

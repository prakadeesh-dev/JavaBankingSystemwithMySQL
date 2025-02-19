# ✨ Java Banking System with MySQL ✨

This is a simple **Bank Account Management System** implemented in **Java** with **MySQL** as the database. The system allows users to create accounts, view accounts, deposit and withdraw funds, and delete accounts.

---

## 🚀 Features

✅ **Create a new bank account**

- Users can provide their name and an initial deposit amount.
- The system assigns a unique account ID automatically.

✅ **View account details by name**

- Users can search for an account using the account holder’s name.
- The system displays the account ID, name, and current balance.

✅ **Deposit money into an account**

- Users enter an account ID and an amount to deposit.
- The system updates the account balance accordingly.

✅ **Withdraw money from an account (with balance validation)**

- Users enter an account ID and an amount to withdraw.
- The system ensures that the balance is sufficient before completing the transaction.

✅ **Delete an account**

- Users enter an account ID to permanently remove the account from the database.

---

## 🛠 Technologies Used

🔹 **Java** - Core programming language used for development.\
🔹 **MySQL** - Relational database for storing account details.\
🔹 **JDBC** - Java Database Connectivity API to interact with MySQL.

---

## 🎯 Getting Started

### 📌 Prerequisites

- Install **Java (JDK 8 or later)**
- Install **MySQL**
- Configure MySQL with the following credentials:
  - **Username:** `root`
  - **Password:** `1234`

📌 **Create the Database and Table:**

```sql
CREATE DATABASE bankdatabase;

USE bankdatabase;

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL CHECK (balance >= 0)
);
```

---

## 🏗 Installation

1️⃣ **Clone this repository:**

```sh
git clone https://github.com/prakadeesh-dev/JavaBankingSystemwithMySQL.git
```

2️⃣ **Open the project in your preferred Java IDE.**\
3️⃣ **Compile and run the ****`Main`**** class.**

---

## 📌 Usage

When you run the program, you will be presented with the following options:

```plaintext
1. Create Account
2. View Accounts
3. Deposit
4. Withdraw
5. Delete Account
6. Exit
```

### ✅ Example Outputs

📌 **Creating an Account**

```plaintext
Enter name: Prakadeesh
Enter initial balance: 50000
Account created successfully! 
```

📌 **Viewing an Account**

```plaintext
Enter name: Prakadeesh
ID: 1, Name: Prakadeesh, Balance: 50000.0
```

📌 **Depositing Money**

```plaintext
Enter Account ID: 1
Enter amount to deposit: 20000
Deposit successful! New Balance: 70000.0
```

📌 **Withdrawing Money**

```plaintext
Enter Account ID: 1
Enter amount to withdraw: 10000
Withdrawal successful! New Balance: 60000.0
```

📌 **Deleting an Account**

```plaintext
Enter Account ID to delete: 1
Account deleted successfully!
```

---

## 📂 Code Overview

### 📌 `Main.java`

🎯 This is the **entry point** of the application. It provides a **menu-driven console interface** for users to interact with the system.

### 📌 `DatabaseHandler.java`

🔹 This class handles all **database operations** such as **creating accounts, retrieving account details, updating balances, and deleting accounts** using JDBC.

---

## 📜 License

📢 This project is open-source and available under the **MIT License**.

---

## 👤 Author

- ✨ **Prakadeesh Raj S S**
- 🔗 **GitHub:** [prakadeesh-dev](https://github.com/prakadeesh-dev)

---

## 🤝 Contributions

🚀 **Feel free to contribute** by submitting issues or pull requests.

---

## 📧 Contact

📩 For any inquiries, you can reach out at [prakadeeshrajss@gmail.com](mailto\:prakadeeshrajss@gmail.com).


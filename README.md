
# bankSimulation

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a simple Java system that simulates a bank, allowing client creation, storage in a SQLite database, and transactions between clients.

## 🚀 Features

- Create clients and save them in a SQLite database  
- Perform transactions between clients

## 🧑‍💻 Technologies Used

- `Java`  
- `SQLite`  
- `Maven`  
- `Jakarta Mail`

## 📋 How to Run

### 🐧 On Linux and macOS

1. Make sure Maven is installed and configured:  
   ```bash
   mvn -v
   ```

2. Clone the repository (if you haven't yet):  
   ```bash
   git clone https://github.com/lemavos/bankSimulation.git
   cd bankSimulation
   ```

3. Compile and run the project with Maven:  
   ```bash
   chmod +x run.sh
   ./run.sh
   ```

### 🪟 On Windows

1. Install Maven and configure it in your PATH. Verify with:  
   ```powershell
   mvn -v
   ```

2. Clone the repository:  
   ```powershell
   git clone https://github.com/lemavos/bankSimulation.git
   cd bankSimulation
   ```

3. Compile and run:  
   ```powershell
   ./run.bat
   ```

## 🤖 How It Works

- The system creates and manages clients, storing their data in a SQLite database.  
- It allows clients to perform transactions between each other.

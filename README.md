# bankSimulation

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a simple Java system that simulates a login, allowing client creation, storage in a SQLite database.

## 🚀 Features

- Create clients and save them in a SQLite database
- Email Sender for verification code

## 🧑‍💻 Technologies Used

- `Java`
- `SQLite`
- `Maven`
- `Jakarta Mail`

## 📋 How to Run

### First read ".env.md" to create your email sender, after that:

### 🐧 On Linux and macOS

1. Make sure Maven is installed and configured:
   ```bash
   mvn -v
   ```

2. Clone the repository (if you haven't yet):
   ```bash
   git clone https://github.com/lemavos/loginSimulation.git
   cd loginSimulation
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
   git clone https://github.com/lemavos/loginSimulation.git
   cd loginSimulation
   ```

3. Compile and run:
   ```powershell
   ./run.bat
   ```

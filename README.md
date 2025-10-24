# Java Spring Boot - Veterinary Management System Graduation Project

## Veterinary Management System

With this project, you are expected to build an API that allows a veterinary clinic to manage its daily operations.
The application will be used by clinic staff.
Through this system, users will be able to:

- Register veterinarians
- Save veterinarians’ available working days (only date, without time)
- Register customers
- Register animals belonging to customers
- Record vaccines applied to animals with their dates
- Create appointments for animals with veterinarians
- While creating appointments:
    - The system must check if the selected date is available in the veterinarian’s schedule (day check without time)
    - The system must also check existing appointments for conflicts (date and time)
    - Appointments can only be created if there are no conflicts

---

## Requirements Analysis

[Requirements Analysis](readme_files/Requirements_Analysis.md)

---

## Pre-Development Analysis

### 1. Business Flow

[Business Flow Analysis](readme_files/Flow_Chart_Diagrams.md)

### 2. Database Diagram

Right click to image and open image in new tab for detail preview

<img src="documents/db_diagram/before/db_uml.svg" style="width: 50%; height: 50%">

### 3. Class Diagram for Service Layer

Right click to image and open image in new tab for detail preview

<img src="documents/class_diagrams/services/before/service_classes.svg" style="width: 50%; height: 50%">

### 4. Class Diagram for Controllers

Right click to image and open image in new tab for detail preview

<img src="documents/class_diagrams/services/before/contoller_classes.svg" style="width: 50%; height: 50%">

---

## Post-Development Outputs

### 1. Database Diagram

Right click to image and open image in new tab for detail preview

<img src="documents/db_diagram/after/db_uml.svg" style="width: 20%; height: 50% ">

### 2. Class Diagram for Service Layer

Right click to image and open image in new tab for detail preview

<img src="documents/class_diagrams/services/after/service_classes.svg" style="width: 50%; height: 50% ">

---

## Postman Documentation

<a href = "documents/vet_system_api.postman_collection.json">Documentation Export File</a>

Use this URL as the base URL for all API requests: https://www.alibiner.com

Example request URL: https://www.alibiner.com/api/v1/cities

---

## Tools and Technologies

### Technologies

1. Java 21
2. PostgreSQL 17.6
3. Postman
4. pgAdmin

### Framework
1. Spring Boot 3.5.6

### Dependencies
1. spring-boot-starter-actuator
2. spring-boot-starter-web
3. spring-boot-starter-validation
4. modelmapper
5. spring-boot-starter-data-jpa
6. hibernate
7. jackson-core
8. jackson-databind

### Architecture
1. Clean/Hexagonal/Onion Architecture

### Build Tool
1. Maven

---

## Setup Instructions

### Installing PostgreSQL 17.6

- **macOS (Homebrew)**

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

```bash
brew install postgresql@17
```

```bash
brew services start postgresql@17
```

```bash
brew install psql
```

- **linux**

```bash 
sudo apt update
```

```bash 
sudo apt install postgresql-17
```

```bash 
sudo systemctl start postgresql
```

- **windows**
  Download the installer from <a href = "https://www.postgresql.org/download/windows/?utm_source=chatgpt.com" >
  PostgreSQL official site </a> and follow the instructions.
  Make sure the PostgreSQL service is running after installation.

---

### Restoring the Backup

1. Download <a href="documents/vet_system.sql"> DB Backup </a>
2. Open terminal/command prompt.
3. Run the following command to restore the database from backup.
4. If you do not have superuser:

**macOS (Homebrew)**

- Open psql on the terminal

```bash
psql postgres
```

- Create superuser

```bash
CREATE USER <username> WITH PASSWORD 'any passwords';
```

- And Press Enter
- If creating success, close the terminal

**windows**

```bash  
# Windows (Command Prompt)
psql -U <your_postgres_user> -d <your_db_name> -f C:\path\to\backup.sql
```

Replace <your_postgres_user> and <your_db_name> with your PostgreSQL username and database name.
After this, the database is ready to use with the application.

---

## Installing Java JDK 25

This project requires **Java 25** to compile and run.  
Below are instructions for installing JDK 25 on different operating systems.

### macOS

**Option A: Homebrew**

- Update Brew

```bash
brew update
```

- Install JDK 25

```bash
brew install openjdk@25
```

- Add JDK 25 to PATH

```bash
echo 'export PATH="/usr/local/opt/openjdk@25/bin:$PATH"' >> ~/.zshrc
```

```bash
source ~/.zshrc
```

- Verify installation

```bash
java -version
```

**Option B: Official Oracle JDK**

1. Download JDK 25 from Oracle Downloads
2. Install the .dmg file.
3. Verify installation:

```bash 
  java -version
```

### Linux(Ubuntu/Debian)

**Option A: Using apt repository**

```bash
sudo apt update
sudo apt install openjdk-25-jdk

# Verify installation
java -version
```

**Option B: Download from Oracle**

1. Download JDK 25 from Oracle Downloads
2. Download .tar.gz archive.
3. Extract and set JAVA_HOME:

```bash 
tar -xzf jdk-25_linux-x64_bin.tar.gz
sudo mv jdk-25 /opt/

# Add to PATH
echo 'export JAVA_HOME=/opt/jdk-25' >> ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
source ~/.bashrc

# Verify
java -version
```

### Windows

1. Download the JDK 25 installer from Oracle JDK 25 Downloads
2. Run the .exe installer and follow the instructions.
3. Set JAVA_HOME environment variable:
    - Open System Properties → Environment Variables → New System Variable
    - Name: JAVA_HOME
    - Value: path to JDK 25 folder, e.g., C:\Program Files\Java\jdk-25
4. Add %JAVA_HOME%\bin to your PATH variable.
5. Verify installation:

```bash
java -version
javac -version
```

---

## Discussion Forum Project

This project is a Discussion Forum that enables users to post questions, respond with answers, and search for discussions efficiently. The main changes include implementing a UML-based class structure with proper object-oriented relationships between questions and answers, ensuring input validation and error handling to prevent invalid entries, and enhancing search functionality for improved user experience. Additionally, CRUD operations have been integrated with a database to allow persistent storage and management of discussion threads. The code has been optimized by removing redundancies, improving efficiency, and adding comprehensive unit tests to validate key features. Furthermore, detailed documentation and comments have been included to improve readability and maintainability. These improvements make the system more robust, user-friendly, and scalable.

## Prerequisites
Before running the project, ensure that the following are installed on your system:
- Java Development Kit (JDK) 11 or later
- JavaFX SDK
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse

## Accessing and Downloading the Project

### Clone the Repository using SSH:
Since the repository is private and SSH-protected with a password, follow these steps:

1. **Ensure your SSH key is added to GitHub:**
   - Generate a key if not already created:
     ```sh
     ssh-keygen -t rsa -b 4096 -C "test@asu.edu"
     ```
   - Copy the public key (`~/.ssh/id_rsa.pub`) and add it to GitHub under **Settings > SSH and GPG keys**.

2. **Clone the Repository using SSH and Enter the Password:**
   ```sh
   ssh-keyscan github.com 
    ~/.ssh/known_hosts  # Ensure GitHub is a trusted host
   ssh -T git@github.com  # Verify access
   GIT_SSH_COMMAND='sshpass -p "hw2CSE360" ssh -o StrictHostKeyChecking=no' git clone git@github.com:RishithMody/hw2CSE360.git
   ```

3. **Navigate into the Project Directory:**
   ```sh
   cd hw2CSE360
   ```

## Configuring the Project

### JavaFX Setup
JavaFX is required; configure it in your IDE:

#### In Eclipse:
- Add JavaFX libraries in **Project Properties > Java Build Path**.
- Set VM arguments in **Run Configurations > Arguments**.

### Database Configuration
- Ensure the database is running.
- Update database connection details in `DatabaseHelper.java` or any relevant configuration file.

## Running the Project

### Compile the Project
- In Eclipse: Click on **Project > Build Automatically**.

### Run the Main Application
1. Navigate to `AnswersTest.java`.
2. Click **Run**.

## Testing the Project

### Admin Setup:
- Run the project and follow the on-screen instructions to create an admin account.
- Verify that an admin user is created in the database.

### User Registration & Login:
- Create a new user account using the invitation code.
- Test login functionality with correct and incorrect credentials.

### Discussion Page Testing:
- Add questions and ensure they appear in the UI.
- Select a question and add answers.
- Edit and delete questions/answers to verify functionality.

Following these steps will ensure the project is correctly set up and functional.


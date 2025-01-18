# Library Management System 📚

A **Java-based Library Management System** designed to simulate library operations efficiently. This system supports library administration, book borrowing, and resource management, offering a robust solution for managing library workflows.



## Features 🚀

- **User Roles:**
  - Admins: Manage library resources and user accounts.
  - Faculty: Borrow and reserve books or other resources.
  - Students: Access library resources and borrow books.

- **Resource Management:**
  - Physical and electronic resources.
  - Reservation system for resources.
  - Return tracking and borrowing history.

- **Efficiency & Extensibility:**
  - Object-Oriented Design principles for easy extensibility.
  - Modular structure to accommodate additional features.



## Tech Stack 🛠️

- **Programming Language:** Java
- **Tools:**
  - Eclipse IDE
  - Git for version control



## File Structure 📂

```plaintext
project332/
├── src/
│   ├── project332/
│   │   ├── Admin.java
│   │   ├── Book.java
│   │   ├── Borrowable.java
│   │   ├── BorrowRecord.java
│   │   ├── Faculty.java
│   │   ├── Library.java
│   │   ├── LibrarySystemSimulation.java
│   │   ├── MeetingRoom.java
│   │   ├── PhysicalBorrowableBook.java
│   │   ├── PhysicalNonBorrowableBook.java
│   │   └── (more classes)
├── .classpath
├── .gitignore
├── .project
└── README.md
```


## How to Run 🏃‍♀️

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/riwaelkari/Library-Management-System.git
   cd Library-Management-System
   ```

2. **Open in Eclipse:**
   - Import the project as an existing Java project.
   - Navigate to `src/project332/LibrarySystemSimulation.java` to start the program.

3. **Run the Program:**
   ```bash
   Right-click on the `LibrarySystemSimulation.java` file.
   Select `Run As > Java Application`.
   ```

## Simulation Description 📚

The simulation demonstrates the functionality of a **Library Management System** that supports various features for faculties, admins, students, and professors. Below are the key actions performed in the simulation:

### Faculty and Library Creation
- Faculties such as Science, Arts, and Engineering are created, each having multiple libraries.
- Libraries are assigned to faculties for resource management.

### Admin Assignments
- Each library is assigned an admin responsible for managing resources like books, meeting rooms, and electronic devices (PCs, tablets).

### Resource Management
- Admins add books, electronic resources, and meeting rooms to their respective libraries.
- Example resources include:
  - Books: *Introduction to Biology*, *Art History*
  - PCs: *Dell XPS*, *Lenovo ThinkPad*
  - Meeting Rooms: *SciLab 101*, *ArtsRoom 201*

### Configuring Rules
- Admins configure:
  - Borrowing durations and maximum renewals.
  - Penalties for overdue books.
  - Rules for reserving meeting rooms or using electronic resources.

### User Management
- Students and professors are created and assigned to specific faculties.

### Key Functionalities Demonstrated
- **Borrowing and Returning Books**:
  - Borrowing durations and renewal limits are enforced.
  - Overdue penalties are applied as per admin-defined rules.
- **Searching for Books**:
  - Search by title or ISBN is supported.
- **Meeting Room Reservations**:
  - Meeting rooms can be reserved by students or professors within allowed durations.
- **Electronic Resource Usage**:
  - PCs and tablets can be reserved for specified durations based on user and admin-defined rules.

### Cross-Faculty Restrictions
- Students can only borrow books from their faculty's libraries.

### Penalty and Restriction Scenarios
- Overdue books incur penalties, restricting borrowing privileges.
- Students and professors are restricted from reserving or using resources based on configured rules.

### Reporting
- Admins generate reports on:
  - The most borrowed books.
  - The most frequent borrowers.

This simulation showcases the interaction between admins, students, professors, and the library system, highlighting the flexibility and rules enforcement in real-world scenarios.


## License 📜
This project is licensed under the [MIT License](LICENSE).

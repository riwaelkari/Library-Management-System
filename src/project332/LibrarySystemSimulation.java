package project332;

import java.util.List;

public class LibrarySystemSimulation {
	public static void main(String[] args) {
		
		System.out.println("--- Creating Faculties ---");
		 // Step 1: Create faculties
        Faculty science = new Faculty("Science");
        Faculty arts = new Faculty("Arts");
        Faculty engineering = new Faculty("Engineering");

        // Step 2: Create libraries and assign to faculties
        System.out.println("--- Creating Libraries and Adding Libraries to faculties: ---");
        Library sciLibrary1 = new Library("Sci-Library1", "Building A", science, null);
        Library sciLibrary2 = new Library("Sci-Library2", "Building B", science, null);
        Library sciLibrary3 = new Library("Sci-Library3", "Building C", science, null);
        science.addLibrary(sciLibrary1);
        science.addLibrary(sciLibrary2);
        science.addLibrary(sciLibrary3);

        Library artLibrary1 = new Library("Art-Library1", "Building D", arts, null);
        Library artLibrary2 = new Library("Art-Library2", "Building E", arts, null);
        Library artLibrary3 = new Library("Art-Library3", "Building F", arts, null);
        arts.addLibrary(artLibrary1);
        arts.addLibrary(artLibrary2);
        arts.addLibrary(artLibrary3);

        Library engLibrary1 = new Library("Eng-Library1", "Building G", engineering, null);
        Library engLibrary2 = new Library("Eng-Library2", "Building H", engineering, null);
        Library engLibrary3 = new Library("Eng-Library3", "Building I", engineering, null);
        engineering.addLibrary(engLibrary1);
        engineering.addLibrary(engLibrary2);
        engineering.addLibrary(engLibrary3);

        // Step 3: Create admins and assign them to libraries
        System.out.println("\n--- Admins being created and assigned to Libraries ---");
        Admin sciAdmin1 = new Admin("SciAdmin1", "123 Science Rd", "111-111-1111", "sciadmin1@university.edu", "9AM-5PM", sciLibrary1);
        Admin sciAdmin2 = new Admin("SciAdmin2", "124 Science Rd", "111-111-2222", "sciadmin2@university.edu", "9AM-5PM", sciLibrary2);
        Admin sciAdmin3 = new Admin("SciAdmin3", "125 Science Rd", "111-111-3333", "sciadmin3@university.edu", "9AM-5PM", sciLibrary3);

        sciLibrary1.setAdmin(sciAdmin1);
        sciLibrary2.setAdmin(sciAdmin2);
        sciLibrary3.setAdmin(sciAdmin3);

        Admin artAdmin1 = new Admin("ArtAdmin1", "456 Art St", "222-222-1111", "artadmin1@university.edu", "9AM-5PM", artLibrary1);
        Admin artAdmin2 = new Admin("ArtAdmin2", "457 Art St", "222-222-2222", "artadmin2@university.edu", "9AM-5PM", artLibrary2);
        Admin artAdmin3 = new Admin("ArtAdmin3", "458 Art St", "222-222-3333", "artadmin3@university.edu", "9AM-5PM", artLibrary3);

        artLibrary1.setAdmin(artAdmin1);
        artLibrary2.setAdmin(artAdmin2);
        artLibrary3.setAdmin(artAdmin3);

        Admin engAdmin1 = new Admin("EngAdmin1", "789 Eng Ave", "333-333-1111", "engadmin1@university.edu", "9AM-5PM", engLibrary1);
        Admin engAdmin2 = new Admin("EngAdmin2", "790 Eng Ave", "333-333-2222", "engadmin2@university.edu", "9AM-5PM", engLibrary2);
        Admin engAdmin3 = new Admin("EngAdmin3", "791 Eng Ave", "333-333-3333", "engadmin3@university.edu", "9AM-5PM", engLibrary3);

        engLibrary1.setAdmin(engAdmin1);
        engLibrary2.setAdmin(engAdmin2);
        engLibrary3.setAdmin(engAdmin3);
        
        
        
     // Step 5: Admin populates libraries with resources
     // Add books to libraries
     System.out.println("\n--- Admins adding all kinds of resources ---\n");
     System.out.println("\nAdmins adding books:");

     // SciAdmin1 adding books
     sciAdmin1.addBook(new PhysicalBorrowableBook("Introduction to Biology", "John Doe", "1234567890", "Biology", "A basic introduction to biology.", true));
     sciAdmin1.addBook(new PhysicalBorrowableBook("Physics for Beginners", "Jane Smith", "0987654321", "Physics", "A beginner's guide to physics.", true));

     // SciAdmin2 adding books
     sciAdmin2.addBook(new PhysicalBorrowableBook("Advanced Chemistry", "Albert Brown", "1122334455", "Chemistry", "Advanced topics in chemistry.", true));
     sciAdmin2.addBook(new PhysicalBorrowableBook("Organic Chemistry", "Marie Curie", "6677889900", "Chemistry", "Fundamentals of organic chemistry.", true));

     // SciAdmin3 adding books
     sciAdmin3.addBook(new PhysicalBorrowableBook("Astronomy 101", "Galileo Galilei", "9988776655", "Astronomy", "An introduction to the universe and its phenomena.", true));
     sciAdmin3.addBook(new PhysicalBorrowableBook("Genetics Explained", "Charles Darwin", "1234432112", "Genetics", "Foundations of genetic theory.", true));

     // EngAdmin1 adding books
     engAdmin1.addBook(new PhysicalBorrowableBook("Mechanics", "Isaac Newton", "5678901234", "Mechanical Engineering", "Foundations of mechanics.", true));
     engAdmin1.addBook(new PhysicalBorrowableBook("Fluid Mechanics", "Bernoulli", "6789012345", "Mechanical Engineering", "Fundamentals of fluid mechanics.", true));

     // EngAdmin2 adding books
     engAdmin2.addBook(new PhysicalBorrowableBook("Circuit Analysis", "James Maxwell", "8765432109", "Electrical Engineering", "Principles of circuit analysis.", true));
     engAdmin2.addBook(new PhysicalBorrowableBook("Electromagnetic Waves", "Hertz", "1122334455", "Electrical Engineering", "Introduction to electromagnetic theory.", true));

     // EngAdmin3 adding books
     engAdmin3.addBook(new PhysicalBorrowableBook("Thermodynamics", "Clausius", "3344556677", "Thermal Engineering", "Basics of thermodynamics.", true));
     engAdmin3.addBook(new PhysicalBorrowableBook("Structural Analysis", "Timoshenko", "4455667788", "Civil Engineering", "Principles of structural engineering.", true));

     // ArtAdmin1 adding books
     artAdmin1.addBook(new PhysicalBorrowableBook("Art History", "Leonardo Da Vinci", "3456789012", "Art History", "A comprehensive history of art.", true));
     artAdmin1.addBook(new PhysicalBorrowableBook("Renaissance Art", "Michelangelo", "4567890123", "Art History", "Exploring the art of the Renaissance period.", true));

     // ArtAdmin2 adding books
     artAdmin2.addBook(new PhysicalBorrowableBook("Music Theory", "Wolfgang Mozart", "6543210987", "Music", "Foundations of music theory.", true));
     artAdmin2.addBook(new PhysicalBorrowableBook("Classical Composers", "Ludwig van Beethoven", "9988776655", "Music", "A deep dive into the classical music composers.", true));

     // ArtAdmin3 adding books
     artAdmin3.addBook(new PhysicalBorrowableBook("Modern Sculpture", "Auguste Rodin", "9988776655", "Sculpture", "A guide to modern sculpture.", true));
     artAdmin3.addBook(new PhysicalBorrowableBook("Abstract Art", "Pablo Picasso", "5566778899", "Art Movements", "Introduction to abstract art.", true));

     // Add electronic resources to libraries
     System.out.println("\nAdmins adding electronic resources (PCs and Tablets):");

     // SciAdmin1 adding electronic resources
     sciAdmin1.addElectronicResource(new PC("Dell XPS", "SciLab 101"));
     sciAdmin1.addElectronicResource(new Tablet("Samsung Galaxy Tab", "Shelf 1"));

     // SciAdmin2 adding electronic resources
     sciAdmin2.addElectronicResource(new PC("HP Envy", "SciLab 102"));
     sciAdmin2.addElectronicResource(new Tablet("Apple iPad", "Shelf 2"));

     // SciAdmin3 adding electronic resources
     sciAdmin3.addElectronicResource(new PC("Acer Aspire", "SciLab 103"));
     sciAdmin3.addElectronicResource(new Tablet("Google Pixel Slate", "Shelf 3"));

     // EngAdmin1 adding electronic resources
     engAdmin1.addElectronicResource(new PC("Lenovo ThinkPad", "EngLab 201"));
     engAdmin1.addElectronicResource(new Tablet("Microsoft Surface", "Shelf 1"));

     // EngAdmin2 adding electronic resources
     engAdmin2.addElectronicResource(new PC("Apple MacBook", "EngLab 202"));
     engAdmin2.addElectronicResource(new Tablet("Huawei MatePad", "Shelf 2"));

     // EngAdmin3 adding electronic resources
     engAdmin3.addElectronicResource(new PC("HP Spectre", "EngLab 203"));
     engAdmin3.addElectronicResource(new Tablet("Samsung Galaxy Tab S6", "Shelf 3"));

     // ArtAdmin1 adding electronic resources
     artAdmin1.addElectronicResource(new PC("Acer Aspire", "ArtsRoom 301"));
     artAdmin1.addElectronicResource(new Tablet("Amazon Fire", "Shelf 1"));

     // ArtAdmin2 adding electronic resources
     artAdmin2.addElectronicResource(new PC("MSI Creator", "ArtsRoom 302"));
     artAdmin2.addElectronicResource(new Tablet("Lenovo Tab P11", "Shelf 2"));

     // ArtAdmin3 adding electronic resources
     artAdmin3.addElectronicResource(new PC("Asus Zenbook", "ArtsRoom 303"));
     artAdmin3.addElectronicResource(new Tablet("Apple iPad Pro", "Shelf 3"));

     // Add meeting rooms to libraries
     System.out.println("\nAdmins adding meeting rooms:");
     sciAdmin1.addMeetingRoom(new MeetingRoom("SciLab 101", "First Floor", 10));
     sciAdmin1.addMeetingRoom(new MeetingRoom("SciLab 102", "Second Floor", 15));

     sciAdmin2.addMeetingRoom(new MeetingRoom("SciLab 201", "First Floor", 12));
     sciAdmin2.addMeetingRoom(new MeetingRoom("SciLab 202", "Second Floor", 18));

     sciAdmin3.addMeetingRoom(new MeetingRoom("SciLab 301", "First Floor", 20));
     sciAdmin3.addMeetingRoom(new MeetingRoom("SciLab 302", "Second Floor", 25));

     engAdmin1.addMeetingRoom(new MeetingRoom("EngLab 101", "First Floor", 20));
     engAdmin1.addMeetingRoom(new MeetingRoom("EngLab 102", "Second Floor", 25));

     engAdmin2.addMeetingRoom(new MeetingRoom("EngLab 201", "First Floor", 22));
     engAdmin2.addMeetingRoom(new MeetingRoom("EngLab 202", "Second Floor", 30));

     engAdmin3.addMeetingRoom(new MeetingRoom("EngLab 301", "First Floor", 24));
     engAdmin3.addMeetingRoom(new MeetingRoom("EngLab 302", "Second Floor", 35));

     artAdmin1.addMeetingRoom(new MeetingRoom("ArtsRoom 101", "First Floor", 15));
     artAdmin1.addMeetingRoom(new MeetingRoom("ArtsRoom 102", "Second Floor", 20));

     artAdmin2.addMeetingRoom(new MeetingRoom("ArtsRoom 201", "First Floor", 18));
     artAdmin2.addMeetingRoom(new MeetingRoom("ArtsRoom 202", "Second Floor", 25));

     artAdmin3.addMeetingRoom(new MeetingRoom("ArtsRoom 301", "First Floor", 20));
     artAdmin3.addMeetingRoom(new MeetingRoom("ArtsRoom 302", "Second Floor", 30));
     
     
     System.out.println("\nAdmin configuring rules for Science faculty");
     sciAdmin1.setBorrowDuration("Student", 3);    //students can borrow for 3 days
     sciAdmin1.setBorrowDuration("Professor", 7);  // profs can borrow for 7 days (1 week)
     sciAdmin1.setMaxRenewals("Professor", 1);   //profs can renew once
     sciAdmin1.setMaxRenewals("Student", 0);  //students not allowed to renew
     
     sciAdmin1.setLatePenaltyDays(2); //have to wait for 2 days to be able to borrow again if a user had returned a book late
     
     sciAdmin1.setStudentsAllowedToReserve(true); //students not allowed to reserve a meeting room
     sciAdmin1.setProfessorsAllowedToReserve(true);  //professors are allowed to reserve meeting rooms
     
     sciAdmin1.setMaxReservationDuration(1); 
     sciAdmin1.setwaitingPeriodToUseAgain(5);// 5 hours waiting period till user can reserve and use an elecrtonic resource again
     
     System.out.println("\nAdmin configuring rules for art faculty");
     artAdmin1.setBorrowDuration("Student", 3);    //students can borrow for 3 days
     artAdmin1.setBorrowDuration("Professor", 7);  // profs can borrow for 7 days (1 week)
     artAdmin1.setMaxRenewals("Professor", 1);   //profs can renew once
     artAdmin1.setMaxRenewals("Student", 0);  //students not allowed to renew
     
     artAdmin1.setLatePenaltyDays(2); //have to wait for 2 days to be able to borrow again if a user had returned a book late
     
     artAdmin1.setStudentsAllowedToReserve(true); //students not allowed to reserve a meeting room
     artAdmin1.setProfessorsAllowedToReserve(true);  //professors are allowed to reserve meeting rooms
     
     artAdmin1.setMaxReservationDuration(1); 
     artAdmin1.setwaitingPeriodToUseAgain(5);// 5 hours waiting period till user can reserve and use an elecrtonic resource again
     
     
     System.out.println("\n--- Creating Students and Professors ---");
     User student1 = new Student("Eva", "123 Dorm Rd", "321-654-9870", "eva@univ.edu", science, "1");
     User professor1 = new Professor("Dr. Green", "789 Faculty St", "654-987-3210", "green@univ.edu", science, "Professor");
     
     User student2 = new Student("Alice", "456 Dorm Rd", "222-111-3333", "alice@univ.edu", arts, "2");
     User professor2 = new Professor("Dr. Blue", "987 Faculty St", "777-888-9999", "blue@univ.edu", arts, "Professor");
     
     User student3 = new Student("Bob", "789 Dorm Rd", "444-555-6666", "bob@univ.edu", engineering, "3");
     User professor3 = new Professor("Dr. White", "654 Faculty St", "555-666-7777", "white@univ.edu", engineering, "Professor");
     
     
     
     System.out.println("\n--- Searching for Books ---");
     List<Book> searchedBooks = student1.searchBooks(sciLibrary1, "title", "Introduction to Biology");
     System.out.println("Search result by title for 'Introduction to Biology': " + searchedBooks);
     
 
     List<Book> searchedBooks2 = professor1.searchBooks(sciLibrary1, "isbn", "0987654321");
     System.out.println("Search result by isbn for '0987654321': " + searchedBooks2);
     System.out.println("\n--- Borrowing Books ---");
     
     student1.borrowBook(searchedBooks.get(0), sciLibrary1);
     
     professor1.borrowBook(searchedBooks2.get(0), sciLibrary1);
     
     
     System.out.println("\n--- Trying to borrow an already borrowed book ---");
     professor1.borrowBook(searchedBooks.get(0), sciLibrary1);
     
     
     System.out.println("\n--- Reserving an already borrowed book ---");
     professor1.reserveBook(searchedBooks.get(0), sciLibrary1);

     
     System.out.println("\n--- Professor Reserving a meeting room ---");
     MeetingRoom room1 = sciLibrary1.getMeetingRooms().get(0);
     professor1.reserve(room1, sciLibrary1, 1);
     
     System.out.println("\n--- Someone Trying to reserve the same meeting room ---");
     student1.reserve(room1, sciLibrary1, 1);
     
     System.out.println("\n--- Student Reserving a meeting room ---");
     MeetingRoom room2 = sciLibrary1.getMeetingRooms().get(1);
     
     student1.reserve(room2, sciLibrary1, 1);
     
     
     System.out.println("\n--- Testing Use of Electronic Resources ---");
     // Use electronic resources
     ElectronicResource pc1 = sciLibrary1.getElectronicResources().get(0);
     ElectronicResource tablet1 = sciLibrary1.getElectronicResources().get(1);
     
   
     System.out.println("\nReserved and attempting to use for valid duration:");
     student1.reserve(pc1, sciLibrary1, 1);
     
     student1.useElectronicResource(pc1, sciLibrary1, 1); // Valid usage
     
     
     System.out.println("\n--- Testing Rules ---");
     System.out.println("\n--- Borrowing book normally for 3 days(set by admin) for student ---");
     Book b4 = artLibrary1.getBooks().get(0);
     student2.borrowBook(b4, artLibrary1);

     
     System.out.println("\n--- Student tries to renew but should fail since admin had set max renewals to 0 for students---");
     student2.renewBook(b4, artLibrary1);
     
     System.out.println("\n--Returning book on time--");
     student2.returnBook(b4, artLibrary1);
     
     System.out.println("\n--- Borrowing book normally for 7 days(set by admin) for professor ---");
     Book b5 = artLibrary1.getBooks().get(1);
     professor2.borrowBook(b5, artLibrary1);
     
     System.out.println("\n--- Professor renewing book: new due date should be 7+7 = 14 days from now ---");
     professor2.renewBook(b5, artLibrary1);
     
     System.out.println("\n--- Professor tries to renew but should fail since admin had set max renewals to 1 for professors---");
    
     professor2.renewBook(b5, artLibrary1);
     
     
     System.out.println("\n--- Testing Overdue Books and Penalty ---");
     // Simulate overdue by manipulating the borrow record
     BorrowRecord record = professor2.getBorrowRecords().get(b5);
     System.out.println("\n(Making the book artificially overdue by making it due 15-14 = 1 days before now (meaning 1 day late)");
     System.out.println("(Admin previously set late penalty to 2 days so this user cannot borrow until 2 days from now)\n");
     record.renew(-15); // Artificially make the book overdue
     System.out.println("--Returning overdue book:--");
     professor2.returnBook(b5, artLibrary1); // Return overdue book and trigger penalty
     
     System.out.println("\n(Professor under penalty trying to borrow a book now)");
     professor2.borrowBook(b4, artLibrary1);//try to borrow a book again
       
     
     MeetingRoom room3 = artLibrary1.getMeetingRooms().get(1);
     
     System.out.println("\n--Trying to reserve meeting room for more than allowed duration(max 1 hour trying for 2 hours)--");
     professor2.reserve(room3, artLibrary1, 2);
     
     System.out.println("\n--Admin changes rules to not allow students to reserve--");
     artAdmin1.setStudentsAllowedToReserve(false);
     
     System.out.println("\n--Student trying to reserve a meeting room--");
     MeetingRoom room4 = artLibrary1.getMeetingRooms().get(0);
     
     student2.reserve(room4, artLibrary1, 1);
     
     
     System.out.println("\n--- Testing Electronic Resources rules---");
     // Use electronic resources
   
     ElectronicResource pc2 = artLibrary1.getElectronicResources().get(0);
     
     System.out.println("--Professor (who's not allowed by admin) tries to use electronic resource--");
     professor2.useElectronicResource(pc2, artLibrary1, 1);
   
     System.out.println("--\nAdmin changes rule to allow usage for 5 hours--");
     artAdmin1.setMaxUsageDuration(5);
     System.out.println("\n--Student 2 reserves and uses for 1 hour and then for 4 hours--");
     student2.reserve(pc2, artLibrary1, 1);
     
     student2.useElectronicResource(pc2, artLibrary1, 1); // Valid usage
     student2.useElectronicResource(pc2, artLibrary1, 4); // Valid usage
     
     System.out.println("--Student used for 5 hours (max), trying to use for 1 more hour--");
     student2.useElectronicResource(pc2, artLibrary1, 1); 
     
     System.out.println("\n--Student trying to reserve again(renew reservation)--");
     student2.reserve(pc2, artLibrary1, 1);
     
     
     System.out.println("\n--Student from art faculty trying to borrow book from sciLibrary1 which belongs to science faculty--");
     student2.borrowBook(searchedBooks.get(0), sciLibrary1);
     
     

     System.out.println("\n--Art admin 1 generating reports--");
     artAdmin1.viewFrequentBooks();
     System.out.println("");
     artAdmin1.viewFrequentBorrowers();
     
  
     
     System.out.println("\n--Art Admin viewing all currently borrowed books in science faculty libraries (borrow logs)--");
     List<String> borrowLogs = artAdmin1.viewBorrowLogs();
     System.out.println(borrowLogs);
     
     System.out.println("\n--Art Admin viewing all returned books in science faculty libraries (return logs)--");
     List<String> retLogs = artAdmin1.viewReturnLogs();
     System.out.println(retLogs);
     
     
     //System.out.println("Professor attempts to use(Denied for professor due to rule, should be unsuccessful)");
     //professor1.useElectronicResource(pc1, sciLibrary1, 1); // Denied for professor due to rule
     //System.out.println("\nTrying to use more than allowed duration by admin(Exceeding max duration, should be unsuccessful)");
     //student1.useElectronicResource(tablet1, sciLibrary1, 2); // Exceeding max duration
     
        /*
        // Step 4: Admin configures rules for each faculty
        System.out.println("\nAdmin configuring rules for Science faculty");
        sciAdmin.setBorrowDuration("Student", 3);
        sciAdmin.setBorrowDuration("Professor", 7);
        sciAdmin.setMaxRenewals("Professor", 1);
        sciAdmin.setMaxRenewals("Student", 0);
        sciAdmin.setLatePenaltyDays(2);
        sciAdmin.setStudentsAllowedToReserve(true);
        sciAdmin.setMaxUsageDuration(1);

        System.out.println("\nAdmin configuring rules for Art faculty");
        artAdmin.setBorrowDuration("Student", 5);
        artAdmin.setBorrowDuration("Professor", 10);
        artAdmin.setMaxRenewals("Professor", 2);
        artAdmin.setLatePenaltyDays(3);
        artAdmin.setStudentsAllowedToUse(true);

        System.out.println("\nAdmin configuring rules for Engineering faculty");
        engAdmin.setBorrowDuration("Student", 2);
        engAdmin.setBorrowDuration("Professor", 5);
        engAdmin.setMaxRenewals("Professor", 1);
        engAdmin.setLatePenaltyDays(1);
        engAdmin.setStudentsAllowedToReserve(false);
	

        // Step 5: Admin populates libraries with resources
        // Add books to libraries
        System.out.println("\n--- Admins adding all kinds of resources- --\n");
        System.out.println("\nAdmins adding books:");
        sciAdmin.addBook(new PhysicalBorrowableBook("Introduction to Biology", "John Doe", "1234567890","Science Genre1", "A basic introduction to biology.", true));
        sciAdmin.addBook(new PhysicalBorrowableBook("Physics for Beginners", "Jane Smith",  "0987654321", "Physics Genre1", "A beginner's guide to physics.", true));
        sciAdmin.addBook(new PhysicalBorrowableBook("Advanced Chemistry", "Albert Brown", "1122334455", "Chem genre1", "Advanced topics in chemistry.", true));

        engAdmin.addBook(new PhysicalBorrowableBook("Mechanics", "Isaac Newton",  "5678901234", "Engineering genre1","Foundations of mechanics.", true));
        engAdmin.addBook(new PhysicalBorrowableBook("Circuit Analysis", "James Maxwell",  "8765432109","Engineering genre2", "Principles of circuit analysis.", true));
        engAdmin.addBook(new PhysicalBorrowableBook("Thermodynamics", "Clausius",  "3344556677", "Engineering genre3","Basics of thermodynamics.", true));

        artAdmin.addBook(new PhysicalBorrowableBook("Art History", "Leonardo Da Vinci",  "3456789012","Arts genre1", "A comprehensive history of art.", true));
        artAdmin.addBook(new PhysicalBorrowableBook("Music Theory", "Wolfgang Mozart",  "6543210987", "Arts genre2", "Foundations of music theory.", true));
        artAdmin.addBook(new PhysicalBorrowableBook("Modern Sculpture", "Auguste Rodin",  "9988776655","Arts genre3", "A guide to modern sculpture.", true));

        
        EBook ebook1 = new EBook("AI Fundamentals", "Alan Turing", "111122223333", "Computer Science", "An introduction to AI.");
        EBook ebook2 = new EBook("Digital Painting", "Frida Kahlo", "444455556666", "Art and Design", "A guide to digital painting techniques.");
        sciAdmin.addBook(ebook1);
        artAdmin.addBook(ebook2);
        
        // Add meeting rooms to libraries
        System.out.println("\nAdmins adding meeting rooms:");
        sciAdmin.addMeetingRoom(new MeetingRoom("SciLab 101", "First Floor", 10));
        sciAdmin.addMeetingRoom(new MeetingRoom("SciLab 102", "Second Floor", 15));

        engAdmin.addMeetingRoom(new MeetingRoom("EngLab 201", "First Floor", 20));
        engAdmin.addMeetingRoom(new MeetingRoom("EngLab 202", "Second Floor", 25));

        artAdmin.addMeetingRoom(new MeetingRoom("ArtsRoom 301", "Third Floor", 30));
        artAdmin.addMeetingRoom(new MeetingRoom("ArtsRoom 302", "Fourth Floor", 35));

        // Add electronic resources to libraries
        System.out.println("\nAdmins adding electronic resources(PCs and Tablets):");

        // Add electronic resources (PCs and Tablets) to libraries
        sciAdmin.addElectronicResource(new PC("Dell XPS", "SciLab 101"));
        sciAdmin.addElectronicResource(new PC("HP Envy", "SciLab 102"));
        sciAdmin.addElectronicResource(new Tablet("Samsung Galaxy Tab", "Shelf 1"));
        sciAdmin.addElectronicResource(new Tablet("Apple iPad", "Shelf 2"));

        engAdmin.addElectronicResource(new PC("Lenovo ThinkPad", "EngLab 201"));
        engAdmin.addElectronicResource(new PC("Apple MacBook", "EngLab 202"));
        engAdmin.addElectronicResource(new Tablet("Microsoft Surface", "Shelf 3"));
        engAdmin.addElectronicResource(new Tablet("Huawei MatePad", "Shelf 4"));

        artAdmin.addElectronicResource(new PC("Acer Aspire", "ArtsRoom 301"));
        artAdmin.addElectronicResource(new PC("MSI Creator", "ArtsRoom 302"));
        artAdmin.addElectronicResource(new Tablet("Amazon Fire", "Shelf 5"));
        artAdmin.addElectronicResource(new Tablet("Lenovo Tab P11", "Shelf 6"));
        
        
        

        System.out.println("\n--- Testing Borrowing Books ---");
        // Borrow books
        User student1 = new Student("Eve", "123 Dorm Rd", "321-654-9870", "eve@univ.edu", science, "1");
        User professor1 = new Professor("Dr. Green", "789 Faculty St", "654-987-3210", "green@univ.edu", science, "Professor");
         
        
       
        
        
        System.out.println("");
        Book book1 = sciLibrary1.getBooks().get(0);
        student1.borrowBook(book1, sciLibrary1); // Valid borrowing
        System.out.println("Attempting to borrow an already borrowed book:");
        professor1.borrowBook(book1, sciLibrary1); // Attempt to borrow an already borrowed book
        
        
        List<Book> bor = student1.getBorrowedBooks();
        System.out.println("Student checking his currently borrowed books" + bor);
        
        System.out.println("\n--- Testing Returning Books ---");
        // Return books
        student1.returnBook(book1, sciLibrary1); // Valid return
        
        List<Book> bor2 = student1.getBorrowedBooks();
        System.out.println("Student checking his currently borrowed books after returning" + bor2);
        
        System.out.println("\nAttempt to return a book already returned:");
        student1.returnBook(book1, sciLibrary1); // Attempt to return a book already returned
        
       
       

        System.out.println("\n--- Testing Renewing Books ---");
        // Renew books
        System.out.println("(Borrow a new book for 7 days since admin allows professors 7 days:)");
        Book book2 = sciLibrary1.getBooks().get(1);
        
        professor1.borrowBook(book2, sciLibrary1);
        System.out.println("(The new due date should be 14 days from now:)");
        professor1.renewBook(book2, sciLibrary1); // Valid renewal
        System.out.println("(Attempt to renew again, should fail since admin allowed max 1 renewals for the science faculty)");
        professor1.renewBook(book2, sciLibrary1); // Attempt to renew beyond limit


        System.out.println("\n--- Testing Overdue Books and Penalty ---");
        // Simulate overdue by manipulating the borrow record
        BorrowRecord record = professor1.getBorrowRecords().get(book2);
        System.out.println("(Making the book artificially overdue by making it due 15-14 = 1 days before now)");
        System.out.println("(Admin previously set late penalty to 2 days so this user cannot borrow until 2 days from now)");
        record.renew(-15); // Artificially make the book overdue
        professor1.returnBook(book2, sciLibrary1); // Return overdue book and trigger penalty
        System.out.println("\n(Professor under penalty trying to borrow a book now)");
        professor1.borrowBook(book2, sciLibrary1);//try to borrow a book again
          
        
        
        
        System.out.println("\n--- Testing Access to eBooks ---");
        System.out.println("Accessing eBook from the Science library:");
        student1.accessEBook(ebook1, sciLibrary1); // Should succeed

        System.out.println("\nAttempting to access an eBook from another faculty's library:");
        student1.accessEBook(ebook2, artLibrary1); // Should fail due to faculty restrictions
        
        
        System.out.println("\n--- Testing Reservation of Meeting Rooms ---");
        // Reserve meeting rooms
        MeetingRoom room1 = sciLibrary1.getMeetingRooms().get(0);
        student1.reserve(room1, sciLibrary1, 1); // Valid reservation
        System.out.println("\n(Attempting to reserve an already reserved room)");
        professor1.reserve(room1, sciLibrary1, 2); // Attempt to reserve already reserved room
        System.out.println("\n(Canceling reservation)");
        professor1.cancelReservation(room1, sciLibrary1);
        
        System.out.println("(Trying to reserve again: should succeed)");
        professor1.reserve(room1, sciLibrary1, 1); // trying reserve again
        
        System.out.println("\n(Canceling reservation again)");
        professor1.cancelReservation(room1, sciLibrary1);
        
        System.out.println("(Trying to reserve more than allowed duration set by admin. In this case it is the default of 1 hour)");
        professor1.reserve(room1, sciLibrary1, 3); // Reservation exceeding max duration
        
        System.out.println("\n--- Testing Use of Electronic Resources ---");
        // Use electronic resources
        ElectronicResource pc1 = sciLibrary1.getElectronicResources().get(0);
        ElectronicResource tablet1 = sciLibrary1.getElectronicResources().get(2);
        
        System.out.println("(Attempting to use before reservation:)");
        student1.useElectronicResource(pc1, sciLibrary1, 1); 
        System.out.println("\nReserved and attempting to use for valid duration(should be successful):");
        student1.reserve(pc1, sciLibrary1, 1);
        
        student1.useElectronicResource(pc1, sciLibrary1, 1); // Valid usage
        System.out.println("Professor attempts to use(Denied for professor due to rule, should be unsuccessful)");
        professor1.useElectronicResource(pc1, sciLibrary1, 1); // Denied for professor due to rule
        System.out.println("\nTrying to use more than allowed duration by admin(Exceeding max duration, should be unsuccessful)");
        student1.useElectronicResource(tablet1, sciLibrary1, 2); // Exceeding max duration
        
        System.out.println("\n(Creating new student:)");
        
        User student2 = new Student("Ahmad", "Salim Sleim", "123-654-9870", "ahmad@univ.edu", science, "10");
        System.out.println("\n(New student attempting to use same PC reserved by other student)");
        student2.useElectronicResource(pc1, sciLibrary1, 1);

        
        System.out.println("\n--- Testing Resource Searches ---");
        // Search for books
        List<Book> searchedBooks = student1.searchBooks(sciLibrary1, "title", "Introduction to Biology");
        System.out.println("Search result for 'Introduction to Biology': " + searchedBooks);
        Book bookbio = searchedBooks.get(0);
        System.out.println("\n(Borrowing searched book)");
        student1.borrowBook(bookbio, sciLibrary1);
        
        
        System.out.println("\n--- More Comprehensive Testing for Searches ---");
	
	     // Create additional books for testing
	     sciAdmin.addBook(new PhysicalBorrowableBook("General Science", "Mary Johnson", "3332221110", "General Genre", "Overview of general science topics.", true));
	     sciAdmin.addBook(new PhysicalBorrowableBook("Physics Advanced", "Jane Smith", "1122445566", "Physics Genre1", "Advanced physics concepts.", true));
	
	     // Create additional meeting rooms for testing
	     sciAdmin.addMeetingRoom(new MeetingRoom("SciLab 103", "Third Floor", 20));
	     sciAdmin.addMeetingRoom(new MeetingRoom("SciLab 104", "Fourth Floor", 25));
	
	     // Search for books by different fields
	     System.out.println("\n--- Book Searches ---");
	     List<Book> booksByTitle = student1.searchBooks(sciLibrary1, "title", "Physics for Beginners");
	     System.out.println("Search by title 'Physics for Beginners': " + booksByTitle);
	
	     List<Book> booksByAuthor = student1.searchBooks(sciLibrary1, "author", "Jane Smith");
	     System.out.println("Search by author 'Jane Smith': " + booksByAuthor);
	
	     List<Book> booksByGenre = student1.searchBooks(sciLibrary1, "genre", "Physics Genre1");
	     System.out.println("Search by genre 'Physics Genre1': " + booksByGenre);
	
	     List<Book> booksByISBN = student1.searchBooks(sciLibrary1, "isbn", "3332221110");
	     System.out.println("Search by ISBN '3332221110': " + booksByISBN);

	     // Invalid book search
	     List<Book> invalidBookSearch = student1.searchBooks(sciLibrary1, "title", "Non-Existent Book");
	     System.out.println("Search for non-existent book: " + invalidBookSearch);

        

	     // Search for meeting rooms by different fields
	     System.out.println("\n--- Meeting Room Searches ---");
	     List<MeetingRoom> roomsByName = professor1.searchRooms(sciLibrary1, "name", "SciLab 101");
	     System.out.println("Search by room name 'SciLab 101': " + roomsByName);

	     List<MeetingRoom> roomsByLocation = professor1.searchRooms(sciLibrary1, "location", "Second Floor");
	     System.out.println("Search by location 'Second Floor': " + roomsByLocation);

	     List<MeetingRoom> roomsByCapacity = professor1.searchRooms(sciLibrary1, "capacity", "25");
	     System.out.println("Search by capacity '25': " + roomsByCapacity);
	     
	     // Invalid meeting room search
	     List<MeetingRoom> invalidRoomSearch = professor1.searchRooms(sciLibrary1, "name", "Non-Existent Room");
	     System.out.println("Search for non-existent room: " + invalidRoomSearch);


        
        System.out.println("\n--- Science Admin Generating Reports ---");
        // Generate reports
        
        sciAdmin.viewFrequentBooks();
        System.out.println("");
        sciAdmin.viewFrequentBorrowers();
        
        // Simulate overdue by manipulating the borrow record
        BorrowRecord record1 = student1.getBorrowRecords().get(bookbio);
        System.out.println("\nArtificially making a book overdue so it appears in the report(the previous one is no longer overdue since it has been returned)");
        record1.renew(-25); // Artificially make the book overdue
        
        sciAdmin.generateOverdueBooksReport(science);
        
        
        System.out.println("\n--Science Admin viewing all currently borrowed books in science faculty libraries (borrow logs)--");
        List<String> borrowLogs = sciAdmin.viewBorrowLogs();
        System.out.println(borrowLogs);
        
        System.out.println("\n--Science Admin viewing all returned books in science faculty libraries (return logs)--");
        List<String> retLogs = sciAdmin.viewReturnLogs();
        System.out.println(retLogs);
        
        System.out.println("\n--- Testing Rule Enforcement ---");
        // Change rules dynamically and test enforcement
        System.out.println("\n(Admin changing rules)");
        sciAdmin.setStudentsAllowedToReserve(false); // Disallow students from reserving rooms
        System.out.println("\n(Student attempts to reserve and should fail)");
        student1.reserve(room1, sciLibrary1, 1); // Attempt reservation after rule change
        
        // Access Denial Tests
        System.out.println("\n--- Access Denial Tests ---");
        List<Book> booksInArtLibrary = student1.searchBooks(artLibrary1, "title", "Art History");
        System.out.println("Search for books in Art Library (access denied): " + booksInArtLibrary+"\n");

        List<MeetingRoom> roomsInEngLibrary = professor1.searchRooms(engLibrary1, "name", "EngLab 201");
        System.out.println("Search for rooms in Engineering Library (access denied): " + roomsInEngLibrary);
        
        
     // Testing Accessing Non-Borrowable Resources
        System.out.println("\n--- Accessing Non-Borrowable Resources ---");
        PhysicalNonBorrowableBook nonBorrowableBook = new PhysicalNonBorrowableBook("Special Collection", "Unique Author", "4443332221", "Special Genre", "Non-borrowable item.");
        sciLibrary1.addBook(nonBorrowableBook);

        student1.accessNonBorrowableBook(nonBorrowableBook, sciLibrary1); // Valid access
        professor1.accessNonBorrowableBook(nonBorrowableBook, sciLibrary1); // Valid access
        System.out.println("(Attempt to access non-borrowable resource in a restricted library, meaning library in a different faculty from the user)");
        // Attempt to access non-borrowable resource in a restricted library
        student1.accessNonBorrowableBook(nonBorrowableBook, artLibrary1); // Access denied

        
        // Testing edge cases
        System.out.println("\n--- Edge Case Testing ---");
        // Search in an empty library
        Library emptyLibrary = new Library("Empty Library", "Building X", science, null);
        List<Book> booksInEmptyLibrary = student1.searchBooks(emptyLibrary, "title", "Any Book");
        System.out.println("Search in empty library: " + booksInEmptyLibrary);

        List<MeetingRoom> roomsInEmptyLibrary = professor1.searchRooms(emptyLibrary, "name", "Any Room");
        System.out.println("Search for rooms in empty library: " + roomsInEmptyLibrary);

        
        
        System.out.println("\n--- Testing Admin Book Management ---");

        System.out.println("(Admin views all books initially)");
        sciAdmin.viewAllBooks();

        System.out.println("\n(Admin deletes a book by ISBN: 1234567890)");
        sciAdmin.deleteBook("1234567890"); // Delete the book with ISBN 1234567890

        System.out.println("\n(Admin views all books after deletion)");
        sciAdmin.viewAllBooks();

        System.out.println("\n(Admin attempts to delete a non-existing book)");
        sciAdmin.deleteBook("9999999999"); // Attempt to delete a book that doesn't exist


        System.out.println("\n--- Testing Completion ---");
        System.out.println("All tests executed.");

        
        */
     
       
	}
	
	

}

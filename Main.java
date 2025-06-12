public class Main {
    // Part 1: Main method to print "Welcome to CS 112!"
    public static void main(String[] args) {
        System.out.println("Welcome to CS 112!");
        
        // Testing the static methods
        printGreeting("Alice");
        int squareResult = squareNumber(5);
        System.out.println("Square of 5 is: " + squareResult);
        
        // Testing the Book class
        Book book1 = new Book("The Great Gatsby", 180);
        Book book2 = new Book("1984", 328);
        Book book3 = new Book("The Great Gatsby", 180);
        Book book4 = new Book(book1); // Using copy constructor
        
        System.out.println(book1);
        book1.setPageCount(200);
        System.out.println("Updated page count: " + book1.getPageCount());
        System.out.println("Book1 equals Book2: " + book1.equals(book2));
        System.out.println("Book1 equals Book3: " + book1.equals(book3));
        System.out.println("Copy constructor test: " + book4);
    }
    
    // Part 2: Static methods
    // Void static method with a parameter
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "! Welcome to the program.");
    }
    
    // Value-returning static method with a parameter
    public static int squareNumber(int number) {
        return number * number;
    }
}

// Part 3: Programmer-defined class
class Book {
    // Instance variable
    private int pageCount;
    
    // Additional instance variable to make equals method more meaningful
    private String title;
    
    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.pageCount = 0;
    }
    
    // Full constructor
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount >= 0 ? pageCount : 0; // Ensure non-negative page count
    }
    
    // Hacker Challenge: Copy constructor
    public Book(Book other) {
        this.title = other.title;
        this.pageCount = other.pageCount;
    }
    
    // toString method
    @Override
    public String toString() {
        return "Book: " + title + ", Pages: " + pageCount;
    }
    
    // Mutator/setter for pageCount
    public void setPageCount(int pageCount) {
        if (pageCount >= 0) {
            this.pageCount = pageCount;
        }
    }
    
    // Accessor/getter for pageCount
    public int getPageCount() {
        return pageCount;
    }
    
    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return this.pageCount == other.pageCount && 
               this.title.equals(other.title);
    }
}

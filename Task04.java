import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Task04 {
    public static void main(String[] args) {

        Student s1 = new Student("Brown", "Kevin", "CS101");
        Student s2 = new Student("Johns", "Berton", "CS102");

        Book b1 = new Book("How to solve?", "John Doe");
        Book b2 = new Book("NO fears", "Jane Smith");

        Library library = new Library();

        library.issueBook(s1, b1, 7);
        library.issueBook(s2, b2, 3);

        library.returnBook(s2.getCard(), b2, LocalDate.now().plusDays(5)); // опоздал на 2 дня

        System.out.println("Debtors:");
        List<Student> debtors = library.getDebtors();
        for (Student s : debtors) {
            System.out.println(s);
        }
    }
}

class Student {
    private String lastName;
    private String firstName;
    private String group;
    private LibraryCard card;

    public Student(String lastName, String firstName, String group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.card = new LibraryCard(); // auto card
    }

    public LibraryCard getCard() {
        return card;
    }
//redefinition
    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + group + "), Card: " + card.getNumber();
    }
}

class LibraryCard {
    private static int nextNumber = 1;
    private int number;

    public LibraryCard() {
        this.number = nextNumber++;
    }

    public int getNumber() {
        return number;
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
// getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

class IssueRecord {
    private Book book;
    private LibraryCard card;
    private LocalDate issueDate;
    private int days;

    public IssueRecord(Book book, LibraryCard card, int days) {
        this.book = book;
        this.card = card;
        this.issueDate = LocalDate.now();
        this.days = days;
    }
//getters
    public Book getBook() { return book; }
    public LibraryCard getCard() { return card; }
    public LocalDate getDueDate() { return issueDate.plusDays(days); }
}

class ReturnRecord {
    private Book book;
    private LibraryCard card;
    private LocalDate returnDate;

    public ReturnRecord(Book book, LibraryCard card, LocalDate returnDate) {
        this.book = book;
        this.card = card;
        this.returnDate = returnDate;
    }

    public Book getBook() { return book; }
    public LibraryCard getCard() { return card; }
    public LocalDate getReturnDate() { return returnDate; }
}

class Library {
    private List<IssueRecord> issued = new ArrayList<>();
    private List<ReturnRecord> returned = new ArrayList<>();
    private Map<LibraryCard, Student> cardToStudent = new HashMap<>();

    public void issueBook(Student student, Book book, int days) {
        IssueRecord record = new IssueRecord(book, student.getCard(), days);
        issued.add(record);
        cardToStudent.putIfAbsent(student.getCard(), student); // student info by card
    }

    public void returnBook(LibraryCard card, Book book, LocalDate returnDate) {
        ReturnRecord record = new ReturnRecord(book, card, returnDate);
        returned.add(record);
    }

    public List<Student> getDebtors() {
        List<Student> debtors = new ArrayList<>();
        for (IssueRecord ir : issued) {
            boolean returnedOnTime = false;
            for (ReturnRecord rr : returned) {
                if (rr.getCard() == ir.getCard() && rr.getBook() == ir.getBook()) {
                    if (!rr.getReturnDate().isAfter(ir.getDueDate())) {
                        returnedOnTime = true;
                    }
                    break;
                }
            }
            if (!returnedOnTime) {
                Student s = cardToStudent.get(ir.getCard());
                if (s != null && !debtors.contains(s)) {
                    debtors.add(s);
                }
            }
        }
        return debtors;
    }
}

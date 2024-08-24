import java.time.LocalDate;


public class BorrowBook {
    private Book book;
    private String userName;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowBook(Book book, String userName,LocalDate returnDate) {
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.returnDate = returnDate;
        this.userName = userName;
    }

    public Book getBook() {
        return book;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

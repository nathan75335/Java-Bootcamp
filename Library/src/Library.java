import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private List<Book> bookList = new ArrayList<>();
    private List<BorrowBook> borrowBooks = new ArrayList<>();
    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    public void addBorrowBook(BorrowBook book) {
        borrowBooks.add(book);
    }

    public List<BorrowBook> getBorrowBooks() {
        return this.borrowBooks;
    }

    public void removeBorrowBook(BorrowBook book) {
        borrowBooks.remove(book);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }

}

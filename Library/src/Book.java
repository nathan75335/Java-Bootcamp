public class Book {
    private String name;
    private String author;
    private String iSBN;
    private String editionHouse;
    private Genre genre;
    private boolean isBorrowed = false;

    public Book(){

    }

    public Book(String name, String author, String iSBN, String editionHouse) {
        this.name = name;
        this.author = author;
        this.iSBN = iSBN;
        this.editionHouse = editionHouse;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsBorrowed() {
        return this.isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed){
        this.isBorrowed = true;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getISBN() {
        return iSBN;
    }
    public void setISBN(String ISBN) {
        this.iSBN = ISBN;
    }
    public String getEditionHouse() {
        return this.editionHouse;
    }
    public void setEditionHouse(String editionHouse) {
        this.editionHouse = editionHouse;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Genre getGenre() {
        return this.genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public  void showBook(){
        System.out.println("The book found: " + this.name);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.iSBN);
        System.out.println("Genre: " + this.genre.getName());
        System.out.println("Edition house: " + this.editionHouse);
    }

}

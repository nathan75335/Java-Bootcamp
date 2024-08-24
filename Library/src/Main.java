import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Projet 10 : Système de Gestion de Bibliothèque Objectif du Projet
        Créer un système de gestion de bibliothèque pour suivre les livres, les emprunts et les retours.
        Description du Programme
        Le programme permet d'ajouter, de supprimer, d'emprunter et de retourner des livres. Il affiche également la liste des
        livres disponibles.
        Fonctionnalités
        • Gestion des livres : ajout, suppression, emprunt, retour.
        • Affichage des livres disponibles.
        Instructions de Développement
        1. Utiliser une liste pour stocker les livres.
        2. Implémenter une logique pour vérifier l'état d'emprunt des livres.
        Extension Potentielle
        • Ajouter des catégories de livres et permettre la recherche par catégorie.
        • Intégrer un système de notifications pour les retards.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the library");
        Library library = new Library(scanner.nextLine());

        while (true){
            System.out.println("1. Add a book to the library");
            System.out.println("2. Remove a book from the library");
            System.out.println("3. Search a book by title");
            System.out.println("4. Search a book by Genre");
            System.out.println("5. Borrow a book");
            System.out.println("6. Return a book");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            String bookName = "";
            var count = 0;
            switch(option){
                case 1:
                    var book =  new Book();
                    System.out.println("Enter the name of the book");
                    book.setName(scanner.next());
                    System.out.println("Enter the author of the book");
                    book.setAuthor(scanner.next());
                    System.out.println("Enter the ISBN of the book");
                    book.setISBN(scanner.next());
                    System.out.println("Enter the genre of the book");
                    var genre = new Genre(scanner.next());
                    book.setGenre(genre);
                    System.out.println("Enter the edition house of the book");
                    book.setEditionHouse(scanner.next());
                    library.addBook(book);

                    System.out.println("The book has successfully been added to the library");
                    break;

                case 2:
                    System.out.println("Enter the name of the book you want to remove!");
                    bookName = scanner.next();

                    for(var bookSearched : library.getBookList()){
                        if(bookSearched.getName().equals(bookName)){
                            library.removeBook(bookSearched);
                        }
                    }

                    System.out.println("The book has been added successfully");

                    break;
                case 3:
                    System.out.println("Enter the name of the book you want to search!");
                    bookName = scanner.next();

                    for(var bookSearched : library.getBookList()){
                        if(bookSearched.getName().equals(bookName)){
                            bookSearched.showBook();
                            count++;
                        }

                    }

                    if(count == 0){
                        System.out.println("The book does not exist");
                    }
                    break;
                case 4:
                        System.out.println("Enter the genre of the book of the book you want to search!");
                        var bookGenre = scanner.next();
                        var bookResults = new ArrayList<Book>();

                        for(var bookSearched : library.getBookList()){
                            if( bookSearched.getGenre() != null && bookSearched.getGenre().getName().equals(bookGenre)){
                                bookResults.add(bookSearched);
                                count ++;
                            }
                        }

                        if(count != 0){
                            for(var bookSearched : bookResults){
                                bookSearched.showBook();
                            }

                        }else{
                            System.out.println("The book does not exist");
                        }



                        break;
                case 5:
                    System.out.println("Enter the name of the book you want to borrow");
                    bookName = scanner.next();
                    var bookToBorrow = new Book();
                    count = 0;
                    for(var bookSearched : library.getBookList()){
                        if(bookSearched.getName().equals(bookName)){
                            bookToBorrow = bookSearched;
                            count ++;
                            break;
                        }
                    }

                    if(count == 0){
                        System.out.println("The book does not exist");
                        break;
                    }

                    if(bookToBorrow.getIsBorrowed()){
                        LocalDate returnDate = LocalDate.now();
                        for(var borrowBook: library.getBorrowBooks()){
                            if(borrowBook.getBook().getName().equals(bookToBorrow.getName())){
                                returnDate = borrowBook.getReturnDate();
                            }
                        }
                        System.out.println("The book is already borrowed and will be return on the "+ returnDate.getDayOfMonth()+"."+returnDate.getMonth()+"."+returnDate.getYear());
                        break;
                    }

                    System.out.println("Enter the return day of the book!");
                    var day = scanner.nextInt();
                    System.out.println("Enter the return month of the book");
                    var month = scanner.nextInt();
                    System.out.println("Enter the return year of the book");
                    var year = scanner.nextInt();
                    System.out.println("Enter your username: ");
                    var userName = scanner.next();
                    //TODO: je dois ajouter ici des verifications pour la date
                    var borrowBook = new BorrowBook(bookToBorrow, userName, LocalDate.of(year, month, day));
                    library.addBorrowBook(borrowBook);
                    bookToBorrow.setIsBorrowed(true);
                    break;
                case 6:
                    System.out.println("Enter the name of the book you want to return!");
                    bookName = scanner.next();
                    for(var bookSearched : library.getBookList()){
                        if(bookSearched.getName().equals(bookName)){
                            bookSearched.setIsBorrowed(false);
                        }
                    }

                    System.out.println("The book has successfully been returned");

            }
        }

    }
}
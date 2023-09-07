package utils;

import java.util.Arrays;
import java.util.List;

public class Book {
    private String bookName;

    private String author;

    private Integer ratings;


    public Book(String bookName, String author, Integer ratings){
        this.bookName = bookName;
        this.author = author;
        this.ratings = ratings;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    public static List<Book> getBooks(){
        Book harry = new Book("Harry Potter", "JK Rowlings", 5 );
        Book hogwarts = new Book("Hogwarts", "JK Rowlings", 4 );
        Book troubled = new Book("Troubled blood", "JK Rowlings", 4 );
        Book google = new Book("Google", "Larry Page", 4 );
        Book chrome = new Book("Chrome", "Larry Page", 3 );
        Book physics = new Book("Concept of Physics", "HC Verma", 4 );
        Book physicsFoundation = new Book("Foundation of Physics", "HC Verma", 5);
        Book science = new Book("Science", "HC Verma", 4);

        return Arrays.asList(harry, hogwarts, troubled, google, chrome, physics, physicsFoundation, science);
    }
}
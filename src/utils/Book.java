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
        Book HP = new Book("Harry Potter", "JK", 4 );
        Book HP2 = new Book("Harry Potter", "JK", 5 );
        Book google = new Book("Google", "lary", 4 );
        Book chrome = new Book("chrome", "lary", 1 );
        Book science = new Book("science", "verma", 4 );
        Book science2 = new Book("science", "einstien", 3 );
        Book science3 = new Book("science", "verma", 5  );

        return Arrays.asList(HP, HP2, google, chrome, science, science2, science3);
    }
}
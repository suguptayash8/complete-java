package stream;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupBy {
    public static void main(String []args){
        Book HP = new Book("Harry Potter", "JK", 4 );
        Book HP2 = new Book("Harry Potter", "JK", 5 );
        Book google = new Book("Google", "lary", 4 );
        Book chrome = new Book("chrome", "lary", 4 );
        Book science = new Book("science", "verma", 4 );
        Book science2 = new Book("science", "einstien", 4 );
        Book science3 = new Book("science", "verma", 5  );

        List<Book> books = Arrays.asList(HP, HP2, google, chrome, science, science2, science3);

        Map<String , List<Book>> bookByAuthor =  books.stream().collect(groupingBy(book -> {
            return book.getAuthor();
        }));

        Map<Integer , List<Book>> bookByRating =  books.stream().collect(groupingBy(book -> {
            return book.getRatings();
        }));

        Map<String , List<Book>> bookByNameAuthor =  books.stream().collect(groupingBy(book -> {
            return (book.getBookName() + "-" + book.getAuthor());
        }));

        bookByAuthor.get("JK").stream().forEach(book -> System.out.println(book));

        System.out.println("By ratings ");
        bookByRating.get(4).stream().forEach(book -> System.out.println(book));

        System.out.println("By name and author");
        bookByNameAuthor.get("science-verma").stream().forEach(book -> System.out.println(book));
    }
}


class Book {
    private String bookName;

    private String author;

    private Integer ratings;


    Book(String bookName, String author, Integer ratings){
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
}


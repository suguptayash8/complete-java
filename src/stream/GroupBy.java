package stream;


import utils.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * [{
 *  *     name:
 *  *     department:
 *  *     rollNumber:
 *  *     subjects:[]
 *  * }]
 */
public class GroupBy {
    public static void main(String []args){


        List<Book> books = Book.getBooks();

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





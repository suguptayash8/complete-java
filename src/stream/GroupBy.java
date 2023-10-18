package stream;


import utils.Book;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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
        //bookByAuthor.entrySet().stream().forEach(printBooks("authorName"));


        Map<String , List<Book>> bookByRating =  books.stream().collect(groupingBy(book -> {
            return String.valueOf(book.getRatings());
        }));
        //bookByRating.entrySet().stream().forEach(printBooks("byRatings"));


        Map<String , List<Book>> bookbyAuthorAndRatings =  books.stream().collect(groupingBy(book -> {
            return (book.getAuthor() + "-" + book.getRatings());
        }));
        bookbyAuthorAndRatings.entrySet().stream().forEach(printBooks("byAuthorAndRating"));
    }

    public static Consumer printBooks(String aggregationKey){
        Consumer<Map.Entry<String, List<Book>>> printBooks = (entry)-> {
            System.out.println("{ " + "\n" +
                    aggregationKey + ": " + entry.getKey() + ",\n" +
                    "bookName: " + entry.getValue().stream().map(book-> book.getBookName() + " ").collect(Collectors.toList()) + ",\n" +
                    "ratings: " + entry.getValue().stream().map(book-> book.getRatings() + " ").collect(Collectors.toList()) + "\n" +
                    "}"
            );
        };

        return printBooks;
    }
}





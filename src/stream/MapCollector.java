package stream;

import utils.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCollector {

    public static void main(String []args){

        buildMap();
        aggregateWithMap();

    }

    public static void aggregateWithMap(){
        Map<String, Integer> bookMap = generateBooks().stream().collect(Collectors.toMap(book -> book.getBookName(), book -> book.getCount(), (existing, replacement)-> {
            return existing + replacement;
        }));
        System.out.println(bookMap);
    }

    public static void buildMap(){
        Map<String, String> bookMap = generateBooks().stream().collect(Collectors.toMap(book -> book.getBookName(), book -> book.getAuthorName(),
                (existing, replace) -> existing + " " + replace));
        System.out.println(bookMap);
    }

    public static List<Books> generateBooks(){
        Books bookA = new Books("bookA", "ABC", 5);
        Books bookD = new Books("bookA", "ABC", 6);
        Books bookB = new Books("bookB", "XYZ", 19);
        Books bookC = new Books("bookC", "QWS", 10);
        Books bookE = new Books("bookC", "QWS", 19);

        List<Books> books = Arrays.asList(bookA, bookB, bookC, bookD, bookE);

        return books;
    }
}

class Books {
    String bookName;

    String authorName;

    Integer count;

    Books(String bookName, String authorName, Integer count){
        this.bookName = bookName;
        this.authorName = authorName;
        this.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

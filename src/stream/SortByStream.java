package stream;

import utils.Book;

import java.util.List;
import java.util.stream.Collectors;

public class SortByStream {
    public static void main(String[] args){
        List<Book> books = Book.getBooks().stream().sorted((book1, book2) ->{
            if(book1.getRatings()>book2.getRatings()){
                return 1;
            }else if(book1.getRatings() == book2.getRatings()){
                return book1.getAuthor().compareTo(book2.getAuthor());
            }

            return -1;
        }).collect(Collectors.toList());

        System.out.println(books);
    }
}

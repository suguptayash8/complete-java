package stream;

import utils.Book;
import utils.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByStream {
    public static void main(String[] args){


        List<Student> sortedStudent = Student.mockStudentList().orElse(new ArrayList<>()).stream()
                .sorted((studA, studB)->{
            int nameCompare = studA.getName().compareTo(studB.getName());
            if(nameCompare  != 0 ){
                return nameCompare;
            }else {
                int totalOfA = studA.getMarks().stream().reduce(0, (numA, numB) -> numA + numB);
                int totalOfB = studB.getMarks().stream().reduce(0, (numA, numB) -> numA + numB);
                if(totalOfB > totalOfA){
                    return 1;
                }else {
                    return -1;
                }
            }
        }).collect(Collectors.toList());


        System.out.println(sortedStudent);
    }

    public static void sortBooks(){
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

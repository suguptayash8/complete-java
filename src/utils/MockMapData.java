package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MockMapData {

    public static Optional<Map<String, Integer>> getBooksCount(){
        Map<String, Integer> mockBooksCount = new HashMap<>();

        mockBooksCount.put("Geeta", 8);
        mockBooksCount.put("Atomic Habits", 4);
        mockBooksCount.put("Harry Potter", 5);
        mockBooksCount.put("HC Verma", 7);
        mockBooksCount.put("book", 11);

        return Optional.of(mockBooksCount);


    }
}

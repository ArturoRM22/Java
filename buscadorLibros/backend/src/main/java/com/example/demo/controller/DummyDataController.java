package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DummyDataController {

    // Map to store books for optimized search
    private final Map<String, Map<String, Object>> bookMap = new HashMap<>();

    public DummyDataController() {
        // Initialize the map with books
        List<Map<String, Object>> books = List.of(
            Map.of("name", "Can't Hurt Me", "author", "David Goggins", "quantity", 10),
            Map.of("name", "Atomic Habits", "author", "James Clear", "quantity", 15),
            Map.of("name", "The Power of Now", "author", "Eckhart Tolle", "quantity", 8),
            Map.of("name", "Deep Work", "author", "Cal Newport", "quantity", 12),
            Map.of("name", "The 7 Habits of Highly Effective People", "author", "Stephen R. Covey", "quantity", 20),
            Map.of("name", "Mindset: The New Psychology of Success", "author", "Carol S. Dweck", "quantity", 9),
            Map.of("name", "The Subtle Art of Not Giving a F*ck", "author", "Mark Manson", "quantity", 14),
            Map.of("name", "How to Win Friends and Influence People", "author", "Dale Carnegie", "quantity", 18),
            Map.of("name", "Grit: The Power of Passion and Perseverance", "author", "Angela Duckworth", "quantity", 7),
            Map.of("name", "Think and Grow Rich", "author", "Napoleon Hill", "quantity", 11)
        );

        // Populate the map with books
        for (Map<String, Object> book : books) {
            String name = ((String) book.get("name")); // Normalize to lowercase
            bookMap.put(name, book);
        }
    }

    // Endpoint to get all books
    @GetMapping("/api/data")
    public List<Map<String, Object>> getAllBooks() {
        return List.copyOf(bookMap.values());
    }

    @GetMapping("/api/book/{name}")
public Map<String, Object> getBookByName(@PathVariable("name") String name) {
    String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);

    Map<String, Object> book = bookMap.get(decodedName);

    if (book == null) {
        return Map.of("error", "Book not found");
    }

    return book;
}

}
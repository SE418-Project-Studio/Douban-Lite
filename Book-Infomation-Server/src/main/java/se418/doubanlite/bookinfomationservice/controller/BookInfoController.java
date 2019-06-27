package se418.doubanlite.bookinfomationservice.controller;

import se418.doubanlite.bookinfomationservice.entity.Book;
import se418.doubanlite.bookinfomationservice.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookInfoController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/book/{bookid}")
    public Book getBookInfo(@PathVariable("bookid") String bookid) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + bookid + "?api_key=" +  apiKey, MovieSummary.class);
        return new Book(bookid, movieSummary.getTitle(), movieSummary.getOverview());
    }

}

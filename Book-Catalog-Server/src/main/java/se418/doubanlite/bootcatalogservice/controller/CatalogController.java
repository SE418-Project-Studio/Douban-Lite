package se418.doubanlite.bootcatalogservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se418.doubanlite.bootcatalogservice.entity.CatalogItem;
import se418.doubanlite.bootcatalogservice.entity.Book;
import se418.doubanlite.bootcatalogservice.entity.UserRating;
import se418.doubanlite.bootcatalogservice.service.BookInfoService;
import se418.doubanlite.bootcatalogservice.service.RatingDataService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CatalogController {

    final BookInfoService bookInfoService;
    final RatingDataService ratingDataService;

    @Autowired
    public CatalogController(BookInfoService bookInfoService,RatingDataService ratingDataService) {
        this.bookInfoService = bookInfoService;
        this.ratingDataService = ratingDataService;
    }

    @Autowired
    private RestTemplate restTemplate;

    /*@HystrixCommand(groupKey = "fallback", commandKey = "fallback", fallbackMethod = "hystrixFallBack")*/
    @RequestMapping("/catalog")
    public List<CatalogItem> getCatalog(@Param("userid") String userid) {

        UserRating userRating = ratingDataService.getUserRatings(userid);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Book book = bookInfoService.getBookInfo(rating.getBookid());
                    return new CatalogItem(book.getName(), book.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }

    public List<CatalogItem> hystrixFallBack(String userId) {
        return Collections.emptyList();
    }
}
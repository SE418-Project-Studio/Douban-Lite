package se418.doubanlite.bootcatalogservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se418.doubanlite.bootcatalogservice.entity.Book;

@FeignClient("book-info-service")
public interface BookInfoService {

    @RequestMapping("/book/{bookid}")
    Book getBookInfo(@PathVariable("bookid") String bookid);

}

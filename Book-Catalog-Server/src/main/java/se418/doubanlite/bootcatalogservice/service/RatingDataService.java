package se418.doubanlite.bootcatalogservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se418.doubanlite.bootcatalogservice.entity.UserRating;

@FeignClient("rating-data-service")
public interface RatingDataService {

    @RequestMapping("/user/{userid}")
    public UserRating getUserRatings(@PathVariable("userid") String userid);

}

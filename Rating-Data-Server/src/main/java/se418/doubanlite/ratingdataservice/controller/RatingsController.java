package se418.doubanlite.ratingdataservice.controller;

import se418.doubanlite.ratingdataservice.entity.Rating;
import se418.doubanlite.ratingdataservice.entity.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingsController {

    @RequestMapping("/user/{userid}")
    public UserRating getUserRatings(@PathVariable("userid") String userid) {
        UserRating userRating = new UserRating();
        userRating.initData(userid);
        return userRating;

    }

}

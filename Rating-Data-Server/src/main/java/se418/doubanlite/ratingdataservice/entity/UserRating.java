package se418.doubanlite.ratingdataservice.entity;

import java.util.Arrays;
import java.util.List;

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("101", 3),
                new Rating("102", 4),
                new Rating("103", 5),
                new Rating("104", 3),
                new Rating("105", 1),
                new Rating("106", 5),
                new Rating("107", 4),
                new Rating("108", 2)
        ));
    }
}

package se418.doubanlite.bootcatalogservice.entity;

public class Rating {

    private String bookid;
    private int rating;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Rating() {
    }

    public Rating(String bookid, int rating) {
        this.bookid = bookid;
        this.rating = rating;
    }

}

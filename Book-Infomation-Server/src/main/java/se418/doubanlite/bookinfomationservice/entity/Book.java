package se418.doubanlite.bookinfomationservice.entity;

public class Book {
    private String bookid;
    private String name;
    private String description;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book() {
    }

    public Book(String bookid, String name, String description) {
        this.bookid = bookid;
        this.name = name;
        this.description = description;
    }
}

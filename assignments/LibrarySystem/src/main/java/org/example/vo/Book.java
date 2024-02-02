package org.example.vo;

public class Book {
    private int id;
    private String title;
    private String writer;
    private String publisher;


    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}

package jpabook.jpashop.controller;

import lombok.Data;

@Data
public class BookForm {
    private Long id;
    private String name;
    private String author;
    private int price;
    private int stockQuantity;
    private String isbn;
}

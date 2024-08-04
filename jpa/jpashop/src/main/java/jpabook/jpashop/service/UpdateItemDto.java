package jpabook.jpashop.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class UpdateItemDto {
    private Long id;
    private String name;
    private String author;
    private int price;
    private int stockQuantity;
    private String isbn;
}

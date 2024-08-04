package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter
@DiscriminatorValue(value = "B")
public class Book extends Item {
    private String author;
    private String isbn;

    @Override
    public void change(String name, String author, int price, int stockQuantity, String isbn) {
        this.setName(name);
        this.author = author;
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
        this.isbn = isbn;
    }
}

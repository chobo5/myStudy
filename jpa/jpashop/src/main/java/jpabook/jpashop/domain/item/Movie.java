package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jpabook.jpashop.domain.item.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "M")
public class Movie extends Item {
    private String director;
    private String actor;


    @Override
    public void change(String name, String director, int price, int stockQuantity, String actor) {
        this.setName(name);
        this.director = director;
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
        this.actor = actor;
    }
}

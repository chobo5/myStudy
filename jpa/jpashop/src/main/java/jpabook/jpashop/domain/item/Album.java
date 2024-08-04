package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "A")
public class Album extends Item {
    private String artist;
    private String etc;


    @Override
    public void change(String name, String artist, int price, int stockQuantity, String etc) {
        this.setName(name);
        this.artist = artist;
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
        this.etc = etc;
    }
}

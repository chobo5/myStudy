package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable //내장 타입
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;

}

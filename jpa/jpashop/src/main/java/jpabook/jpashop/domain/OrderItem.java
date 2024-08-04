package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //실제 주문 금액
    private int orderPrice;

    private int count;

    /**
     * 상품 취소
     * 비즈니스 로직
     */
    public void cancel() {
        item.addStock(count);
    }

    /**
     * 주문상품 전체 가격 조회
     * 조회 로직
     * @return
     */
    public int getTotalPrice() {
        return orderPrice * count;
    }

    /**
     * order에 담을 order_item 생성
     * @param item
     * @param orderPrice
     * @param count
     * @return
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        item.removeStock(count);
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        return orderItem;

    }

    //Setter
    public void setOrder(Order order) {
        this.order = order;
    }
}

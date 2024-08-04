package jpabook.jpashop;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init() {
//        initService.dbInit1();
//        initService.dbInit2();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {
        private final EntityManager entityManager;

        public void dbInit1() {
            Member member = new Member();
            member.setUsername("userA");
            member.setAddress(new Address("서울", "길거리", "000000"));
            entityManager.persist(member);

            Book item1 = new Book();
            item1.setName("JPA1 Book");
            item1.setAuthor("kim");
            item1.setPrice(10000);
            item1.setStockQuantity(100);
            entityManager.persist(item1);

            Book item2 = new Book();
            item2.setName("JPA2 Book");
            item2.setAuthor("kim");
            item2.setPrice(20000);
            item2.setStockQuantity(100);
            entityManager.persist(item2);

            OrderItem orderItem1 = OrderItem.createOrderItem(item1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(item2, 20000, 2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            delivery.setDeliveryStatus(DeliveryStatus.READY);
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            entityManager.persist(order);

        }

        public void dbInit2() {
            Member member = new Member();
            member.setUsername("userB");
            member.setAddress(new Address("부산", "길거리", "999999"));
            entityManager.persist(member);

            Book item1 = new Book();
            item1.setName("Spring1 Book");
            item1.setAuthor("lee");
            item1.setPrice(15000);
            item1.setStockQuantity(300);
            entityManager.persist(item1);

            Book item2 = new Book();
            item2.setName("Spring2 Book");
            item2.setAuthor("lee");
            item2.setPrice(25000);
            item2.setStockQuantity(300);
            entityManager.persist(item2);

            OrderItem orderItem1 = OrderItem.createOrderItem(item1, 15000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(item2, 25000, 2);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            delivery.setDeliveryStatus(DeliveryStatus.READY);
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            entityManager.persist(order);
        }
    }
    
    
}

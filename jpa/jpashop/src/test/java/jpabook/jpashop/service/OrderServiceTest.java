package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        //given
        Member member = createMember();

        Book book = createBook();

        int orderCount = 2;

        //when
        Long orderId = orderService.save(member.getId(), book.getId(), orderCount);

        //then
        Order order = orderRepository.findOne(orderId);
        assertEquals("주문시 주문 상태는 ORDER", OrderStatus.ORDER, order.getOrderStatus());
        assertEquals("주문 상품의 종류가 정확해야합니다", 1,  order.getOrderItems().size());
        assertEquals("주문시 재고가 줄어들어야 합니다", 8, book.getStockQuantity());
        assertEquals("주문 가격은 주문한 모든 상품종류들의 상품 가격 * 상품 개수", 18000 * orderCount, order.getTotalPrice());
    }

    @Test
    public void 주문취소() {
        //given
        Member member = createMember();
        Book book = createBook();
        assertEquals("주문전 재고량", 10, book.getStockQuantity());
        int orderCount = 1;

        Long orderId = orderService.save(member.getId(), book.getId(), orderCount);
        assertEquals("주문 후 재고량", 9, book.getStockQuantity());

        //when
        Long canceledOrderId = orderService.cancel(orderId);
        Order canceledOrder = orderRepository.findOne(canceledOrderId);

        //then
        assertEquals("주문 취소 후 재고량", 10, book.getStockQuantity());
        assertEquals("주문 취소 후 주문 상태", OrderStatus.CANCEL, canceledOrder.getOrderStatus());

    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_수량초과() {
        //given
        Member member = createMember();
        Book book = createBook();
        int orderCount = 11;
        //when

        Long orderId = orderService.save(member.getId(), book.getId(), orderCount);

        //then
        fail("NotEnoughStockException이 터져 이곳에 도달할 수 없습니다.");
    }


    private Book createBook() {
        Book book = new Book();
        book.setName("sql 자격증 시험");
        book.setPrice(18000);
        book.setStockQuantity(10);
        entityManager.persist(book);
        return book;
    }

    private Member createMember() {
        Address address = new Address("화성시", "동탄반석로 71", "1111");
        Member member = new Member();
        member.setUsername("kim");
        member.setAddress(address);
        entityManager.persist(member);
        return member;
    }

}
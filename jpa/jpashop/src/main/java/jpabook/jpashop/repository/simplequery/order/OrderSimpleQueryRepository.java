package jpabook.jpashop.repository.simplequery.order;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {
    private final EntityManager entityManager;

    public List<SimpleOrderQueryDto> findOrderDtos() {
        return entityManager.createQuery("select new jpabook.jpashop.repository.simplequery.order.SimpleOrderQueryDto(o.id, m.username, o.orderDate, o.orderStatus, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d ", SimpleOrderQueryDto.class).getResultList();
    }
}

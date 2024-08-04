package jpabook.jpashop.repository.order.query;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {
    private final EntityManager entityManager;

    public List<OrderQueryDto> findOrderQueryDtos() {
        List<OrderQueryDto> result = getResultList();
        result.forEach(orderQueryDto -> {
            orderQueryDto.setOrderItems(getOrderItemList(orderQueryDto.getId()));
        });
        return result;
    }

    public List<OrderQueryDto> findOrderQueryDtosOptimized() {
        //order, member, delivery를 조인한 주문 목록
        List<OrderQueryDto> result = getResultList();

        //주문 목록에서 주문 id만 추출
        List<Long> orderIds = result.stream()
                .map(orderQueryDto -> orderQueryDto.getId())
                .collect(Collectors.toList());

        //주문 아이디를 갖는 모든 orderItem 목록
        List<OrderItemQueryDto> orderItems = entityManager.createQuery("select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) " +
                        "from OrderItem oi " +
                        "join oi.item i " +
                        "where oi.order.id in :orderIds", OrderItemQueryDto.class)
                .setParameter("orderIds", orderIds)
                .getResultList();

        //orderItem 목록을 orderId로 그룹지은 목록
        Map<Long, List<OrderItemQueryDto>> map = orderItems.stream().collect(Collectors.groupingBy(orderItemQueryDto -> orderItemQueryDto.getOrderId()));

        //result에 orderId별로 orderItems를 넣어줌
        result.forEach(orderQueryDto -> orderQueryDto.setOrderItems(map.get(orderQueryDto.getId())));
        return result;
    }

    public List<OrderFlatDto> findOrderQueryDtosFlat() {
        return entityManager.createQuery("select new jpabook.jpashop.repository.order.query.OrderFlatDto(o.id, m.username, o.orderDate, o.orderStatus, d.address, i.name, oi.orderPrice, oi.count) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d " +
                "join o.orderItems oi " +
                "join oi.item i", OrderFlatDto.class).getResultList();
    }

    private List<OrderItemQueryDto> getOrderItemList(Long orderId) {
        return entityManager.createQuery("select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) " +
                "from OrderItem oi " +
                "join oi.item i " +
                "where oi.order.id = :orderId", OrderItemQueryDto.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }

    private List<OrderQueryDto> getResultList() {
        return entityManager.createQuery("select new jpabook.jpashop.repository.order.query.OrderQueryDto(o.id, m.username, o.orderDate, o.orderStatus, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d ", OrderQueryDto.class).getResultList();
    }
}

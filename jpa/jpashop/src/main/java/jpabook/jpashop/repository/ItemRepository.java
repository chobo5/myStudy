package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager entityManager;

    public Long save(Item item) {
        if (item.getId() == null) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
        return item.getId();
    }

    public Item findOne(Long itemId) {
        return entityManager.find(Item.class, itemId);
    }

    public List<Item> findAll()  {
        return entityManager.createQuery("select i from Item i", Item.class)
                .getResultList();
    }




}

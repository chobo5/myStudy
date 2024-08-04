package study.data_jpa.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.data_jpa.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamJpaRepository {
    private final EntityManager entityManager;

    public Team save(Team team) {
        entityManager.persist(team);
        return team;
    }

    public Long delete(Team team) {
        entityManager.remove(team);
        return team.getId();
    }

    public Optional<Team> findById(Long id) {
        Team team = entityManager.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    public List<Team> findAll() {
        return entityManager.createQuery("select t from Team t", Team.class)
                .getResultList();
    }

    public long count()  {
        return entityManager.createQuery("select count(t) from Team t", Long.class)
                .getSingleResult();
    }
}

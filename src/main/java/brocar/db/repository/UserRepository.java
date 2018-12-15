package brocar.db.repository;

import brocar.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u order by u.username")
    List<User> findAllOrderByUsername();

    User findUserByBcuId(int bcuId);

    User findByUsername(String username);

}

package brocar.service;

import brocar.db.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllOrderByUsername();

    User findByUsername(String username);

    void addAdmin(User user);

    void addUser(User user);

    void addAndUpdateUser(User user);

    void delete(User user);

}

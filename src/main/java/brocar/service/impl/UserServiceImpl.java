package brocar.service.impl;

import brocar.db.entity.User;
import brocar.db.repository.UserRepository;
import brocar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllOrderByUsername() {
        return userRepository.findAllOrderByUsername();
    }

    @Override
    public void addAdmin(User user) {
        user.setActive(true);
        user.setRole("ADMIN");
        userRepository.save(user);
    }

    @Override
    public void addUser(User user) {
        user.setActive(true);
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public void addAndUpdateUser(User user) {
        User editUser = userRepository.findUserByBcuId(user.getBcuId());
        editUser.setRole(user.getRole());
        userRepository.save(editUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}

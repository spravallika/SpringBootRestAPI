package ca.spring.service;

import ca.spring.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    List<UserModel> users = new ArrayList<>();
    private static AtomicLong count = new AtomicLong();

    public UserModel getUserById(long id) {
        UserModel userModel = users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("No user found with id"));
        return userModel;
    }

    public UserModel editUserDetails(long id, UserModel userModel) {
        UserModel userModelUpdate = users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("No user found with id"));
        users.remove(userModelUpdate);
        userModelUpdate.setId(id);
        users.add(userModelUpdate);
        return userModelUpdate;
    }

    public List<UserModel> getAllUsers() {
        return users;
    }

    public List<UserModel> addUser(UserModel userModel) {
        userModel.setId(count.incrementAndGet());
        users.add(userModel);
        return users;
    }

}

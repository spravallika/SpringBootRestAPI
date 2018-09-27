package ca.spring.controller;

import ca.spring.model.UserModel;
import ca.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public List<UserModel> addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PutMapping("/editUser/{id}")
    public UserModel editUser(@RequestBody UserModel userModel, @PathVariable long id) {
        return userService.editUserDetails(id, userModel);
    }

    @GetMapping("/user/{id}")
    public UserModel getUserDetails(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "No user found with given id")
    @ExceptionHandler(RuntimeException.class)
    public void exceptionHandler() {

    }
}

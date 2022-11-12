package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Api(description = "Контроллер для иллюстрации работы swagger")
@RestController
public class RestApiController {
    private final UserService userService;

    @Autowired
    public RestApiController( UserService userService) {
        this.userService = userService;
    }


    @ApiOperation("Получение списка всех записей")
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @ApiOperation("Добавление записи")
    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation("Удаление записи")
    public void pageDelete(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

    @GetMapping("users/{id}")
    @ApiOperation("Получение записи по id")
    public User getUser (@PathVariable("id") long id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/user")
    @ApiOperation("Получение записи по имени")
    public User getUserByUsername (Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user;
    }

    @PutMapping("/users/{id}")
    @ApiOperation("Редактирование записи")
    public void pageEdit(@PathVariable("id") long id,
                                   @Valid @RequestBody User user) {
            userService.update(user);
    }
}

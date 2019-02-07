package com.beskilled.controller;

import com.beskilled.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User(01L, "Mostafisur", "01730959439"));
        list.add(new User(02L, "Sofiqul", "01730959440"));
        list.add(new User(03L, "Mahabub", "01730959441"));
        list.add(new User(04L, "Mortoza", "01730959442"));
    }

    @GetMapping(value = "/")
    public String start() {
        return "hello spring";
    }

    @GetMapping(value = "/lists")
    public List<User> getList() {
        return this.list;
    }

    @GetMapping(value = "/users")
    public User getUser() {
        return new User(01L, "Mostafisur", "01730959439");
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") long userid) {
        User user = null;
        for (User u : list) {
            if (userid == u.getId()) ;
            user = new User();
            user = new User(u.getId(), u.getUserName(), u.getMobail());
            break;
        }
        return user;
    }

    @GetMapping(value = "/addUser")
    public List<User> addUserToList() {
        list.add(new User(5L, "Rashida", "017459016441"));
        return list;
    }

    long id = list.size();

    @GetMapping(value = "/add/{userName}/{mobail}")
    public List<User> addUserToListDynamec(@PathVariable("userName") String username, @PathVariable("mobail") String m) {
        id++;
        list.add(new User(id, username, m));
        return list;
    }
}

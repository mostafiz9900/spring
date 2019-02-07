package com.beskilled.hellomvctwo.Controller;

import com.beskilled.hellomvctwo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User(1L, "mostafis", "0173095"));
        list.add(new User(2L, "Sofiq", "017309514"));
    }

    @GetMapping(value = "/")
    public String start() {
        return "hello java home page ";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "hello test";
    }


    @GetMapping(value = "/users")
    public List<User> getList() {
        return this.list;
    }

    @GetMapping(value = "/user")
    public User getUser() {
        return new User(1L, "mostafis", "0173095");
    }

    @GetMapping(value = "/user/{id}/{mobile}")
    public User getUserById(@PathVariable("id") Long userid, @PathVariable("mobile") String m) {
        User user = null;
        for (User u : list) {
            if (userid == u.getId() && m.equalsIgnoreCase(u.getMobile())) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;

            }
        }
        return user;

    }

    @GetMapping(value = "/addUser")
    public List<User> addUsderToList() {
        list.add(new User(4L, "Mostafiz", "0124"));
        return list;
    }

    long id = list.size();

    @GetMapping(value = "/add/{UserName}/{mobail}")
    public List<User> addUsderToListDynamixally(@PathVariable("UserName") String username, @PathVariable("mobile") String m) {
        id++;
        list.add(new User(id, username, m));
        return list;
    }

    @GetMapping(value = "/del/{id}")
    public List<User> removeUsderToList(@PathVariable("id") Long id) {

        list.remove(id);
        return list;
    }

}

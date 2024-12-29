package com.gfg.casestudy.Controller;

import com.gfg.casestudy.Model.Users;
import com.gfg.casestudy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping
public String getUserPage(Model model)
{
    List<Users> users = userService.getAllUsers();
    model.addAttribute("users", users);

    return "Users";
}

    /*@GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }*/

    @PostMapping
    public Users registerUser(@RequestBody Users user) {
        return userService.registerUser(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable int id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}

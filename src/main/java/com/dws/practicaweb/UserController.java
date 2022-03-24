package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @PostConstruct
    public void init() {
        service.addUser(new User("Jose Manuel", "jmanuel@email.com", "123456789", false));
        service.addUser(new User("Juan Alberto", "jalberto@email.com", "987654321", true));
    }

    @GetMapping("/newUser")
    public String newUser(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam boolean admin){
        User aux = new User(name, email, phoneNumber, admin);
        service.addUser(aux);
        return "userCreated";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model){
        model.addAttribute("users", service.getUsers());
        return "showUsers";
    }

    @GetMapping("/{userId}")
    public String showUser(Model model, @PathVariable long userId){
        User user = service.getUser(userId);
        if (user==null){
            return "error";
        }
        model.addAttribute("user", user);
        return "showUser";
    }

    @GetMapping("/{userId}/updatedUser")
    public String updatedUser(Model model, @PathVariable long userId) {
        model.addAttribute("userId", userId);
        return "updateUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(Model model,@RequestParam long userId, @RequestParam String name, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam boolean admin){
        User aux = new User(name, email, phoneNumber, admin);
        service.updateUser(userId, aux);
        return "updatedUser";

    }

    @GetMapping ("/deleteUser/{userId}")
    public String deleteUser(Model model, @PathVariable long userId){
        model.addAttribute("userId", userId);
        service.deleteUser(userId);
        return "/deleteUser";
    }
}

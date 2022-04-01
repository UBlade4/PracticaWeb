package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiUser")
public class UserRESTController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public HttpEntity<?> getUsers() {

        if (repository.findAll().isEmpty()) {
            return new ResponseEntity<>("No hay juego registrados", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {

        User user = repository.getById(userId);

        if ((repository.findById(userId).isPresent())) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {

        repository.save(user);
        return user;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updatedUser(@PathVariable long userId, @RequestBody User newUser) {

        if ((repository.findById(userId).isPresent())) {
            service.updateUser(userId,newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public HttpEntity<User> deleteUser(@PathVariable long userId) {

        User user = repository.getById(userId);

        if (repository.findById(userId).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            repository.delete(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
}


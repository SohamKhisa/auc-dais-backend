package com.morse_coders.aucdaisbackend.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody Users user) {
        usersService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUserEmail(@PathVariable("id") Long id, @RequestParam(required = false) String email){
        usersService.updateUserEmail(id, email);
    }
}

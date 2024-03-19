package com.ralvarez.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public List<User> index()
    {
        return userService.getAllUsers();
    }

    @PostMapping("user")
    public ResponseEntity<String> create(@RequestBody User request)
    {
        return userService.createUser(request);
    }

    @PutMapping("user/{userId}")
    public  ResponseEntity<String> edit(@PathVariable Long userId, @RequestBody User user)
    {
        return userService.editUser(userId, user);
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<String> delete(@PathVariable Long userId)
    {
        return userService.DeleteUser(userId);
    }

    @GetMapping("user/{userId}")
    public  ResponseEntity<User> detail(@PathVariable Long userId)
    {
        return userService.detailUser(userId);
    }

}

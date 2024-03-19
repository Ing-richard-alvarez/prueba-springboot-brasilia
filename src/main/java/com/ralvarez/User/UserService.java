package com.ralvarez.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public ResponseEntity<String> createUser(@RequestBody User request)
    {

        try {
            userRepository.save(request);
            return new ResponseEntity<>("User Created Successfully", CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create User", INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> editUser(Long userId, User user)
    {
        User existingUser = userRepository.findById(userId).orElse(null);

        if(existingUser == null) {

            return new ResponseEntity<>("User not found", NOT_FOUND);

        }

        try {

            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setAddress(user.getAddress());

            userRepository.save(existingUser);
            return new ResponseEntity<>("User update successfully", OK);

        } catch (Exception e) {

            return new ResponseEntity<>("Failed to update user", INTERNAL_SERVER_ERROR);

        }

    }

    public ResponseEntity<String> DeleteUser(Long userId)
    {
        User existingUser = userRepository.findById(userId).orElse(null);

        if(existingUser == null) {

            return new ResponseEntity<>("User not found", NOT_FOUND);

        }

        try {
            userRepository.deleteById(userId);
            return new ResponseEntity<>("User deleted successfully", OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update user", INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<User> detailUser(Long userId)
    {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);

    }
}

package com.mariki.springjwt.service;

import com.mariki.springjwt.models.ERole;
import com.mariki.springjwt.models.Role;
import com.mariki.springjwt.models.User;
import com.mariki.springjwt.payload.response.MessageResponse;
import com.mariki.springjwt.repository.RoleRepository;
import com.mariki.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

//    @Override
//    public User creatUser(User user) {
//
//        if (user.getCreationDate() == null) {
//            user.setCreationDate( new Date());
//        }
//        return userRepository.save(user);
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User modifyUser(Long id, User user) {

        return userRepository.findById(id)
                .map(u -> {
//                    if (u.getUsername() != user.getUsername() && userRepository.existsByUsername(user.getUsername())) {
//                        throw new RuntimeException(" Error: Username is already taken! ...");
//                    }
//                    if (u.getEmail() != user.getEmail() && userRepository.existsByUsername(user.getEmail())) {
//                        throw new RuntimeException(" Error: Email is already taken! ...");
//                    }
                    u.setLastModificationDate(new Date());
                    if (!user.getFirstName().isEmpty()){
                        u.setFirstName(user.getFirstName());
                    }
                    if (!user.getLastName().isEmpty()){
                        u.setLastName(user.getLastName());
                    }
                    if (!user.getPassword().isEmpty()){
                        u.setPassword(encoder.encode(user.getPassword()));
                    }
                    return userRepository.save(u);
                }).orElseThrow(()-> new RuntimeException("   ! ..."));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" user not found ! ..."));
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "user deleted successfully";
    }
}

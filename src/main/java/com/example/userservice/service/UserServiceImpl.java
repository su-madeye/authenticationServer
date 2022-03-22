package com.example.userservice.service;

import com.example.userservice.Repo.RoleRepo;
import com.example.userservice.Repo.UserRepo;
import com.example.userservice.models.Role;
import com.example.userservice.models.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("saving user: {} to db", user);
        return userRepo.save(user);
    }

    public Role saveRole(Role role) {
        log.info("saving role: {} to db", role);
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rolename);
        log.info("saving role: {} to {}", rolename, username);
        user.getRole().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("view {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("view all");
        return userRepo.findAll();
    }
}

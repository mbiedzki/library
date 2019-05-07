package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Role;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User findUserById(Long id) {
        return userRepository.getOne(id);
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public boolean userIsAdmin(Long id) {
        Set<Role> userRoles = userRepository.getOne(id).getRoles();
        for (Role role : userRoles) {

            if (role.getRole().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }

}
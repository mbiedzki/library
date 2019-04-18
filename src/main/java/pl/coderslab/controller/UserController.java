package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    //add new user ***********************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "user";
    }
    @PostMapping("/add")
    public String add(@Valid User user, BindingResult result, Model model) {

        //check if user name exists
        User userToAdd = userService.findUserByName(user.getName());
        if(userToAdd!=null) {
            model.addAttribute("existsError", true);
            return "user";
        }
        //check validation
        if(result.hasErrors()) {
            return "user";
        }

        userService.addUser(user);
        model.addAttribute("added", true);
        return "redirect:/admin";
    }

    //edit user ***********************************************
    @GetMapping("/edit/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user";
    }
    @PostMapping("/edit/{id}")
    public String editUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    //delete user ***********************************************
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }




}

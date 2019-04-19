package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Role;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("isAdmin")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute("roles")
    public List<Role> getRoles() {return roleRepository.findAll();}

    @GetMapping("/")
    public String userPanel(Model model, Authentication authentication) {
        String loggedUserName = authentication.getName();
        Long userId = userService.findUserByName(loggedUserName).getId();

        //find role
        if(!userService.userIsAdmin(userId)) {
            model.addAttribute("isAdmin", false);
        }

        model.addAttribute("user", userService.findUserById(userId));
        return "redirect:/user/edit/"+userId.toString();
    }

    //add new user ***********************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }
    @PostMapping("/add")
    public String add(@Valid User user, BindingResult result, Model model,
                      @RequestParam String newPassword1, @RequestParam String newPassword2) {

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

        if((!newPassword1.equals(newPassword2)) || newPassword1.length()<4) {
            model.addAttribute("passwordError", true);
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
        return "user";
    }
    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @Valid User user, BindingResult result,
                           Model model, @RequestParam String newPassword1,
                           @RequestParam String newPassword2) {
        //check if user name exists
        User userToVerify = userService.findUserByName(user.getName());
        User userToUpdate = userService.findUserById(id);

        if((userToVerify!=null) && (!userToVerify.getId().equals(userToUpdate.getId()))) {
            model.addAttribute("existsError", true);
            return "user";
        }
        if(result.hasErrors()) {
            return "user";
        }

        if((!newPassword1.equals(newPassword2)) || newPassword1.length()<4) {
            model.addAttribute("passwordError", true);
            return "user";
        }

        //if new password is  null
        userToUpdate.setName(user.getName());
        if(!userToUpdate.getPassword().equals(user.getPassword())) {
            userToUpdate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            userToUpdate.setPassword(user.getPassword());
        }
        userToUpdate.setActive(user.isActive());
        userToUpdate.setRoles(user.getRoles());

        userService.updateUser(userToUpdate);
        return "redirect:/";
    }

    //delete user ***********************************************
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }




}

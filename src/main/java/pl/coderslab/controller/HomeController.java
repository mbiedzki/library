package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.service.BookService;
import pl.coderslab.service.SpringDataUserDetailsService;
import pl.coderslab.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private BookService bookService;

    private final UserService userService;


    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

}

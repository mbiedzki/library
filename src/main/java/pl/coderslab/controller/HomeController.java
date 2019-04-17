package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.service.BookService;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;

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
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String denied() {
        SecurityContextHolder.clearContext();
        return "access-denied";
    }

}

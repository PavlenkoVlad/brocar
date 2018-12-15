package brocar.controller.common;

import brocar.db.entity.User;
import brocar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Authentication authentication, User user, Model model) {

        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }

        User userFromDb = userService.findByUsername(user.getUsername());
        if(userFromDb != null) {
            model.addAttribute("message", "Такой пользователь уже существует");
            return "registration";
        }

        userService.addUser(user);

        return "redirect:/admin";
    }
}

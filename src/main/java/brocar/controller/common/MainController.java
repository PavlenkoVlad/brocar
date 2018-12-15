package brocar.controller.common;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "index";
    }

    @GetMapping("/about")
    public String about(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "contacts";
    }
}

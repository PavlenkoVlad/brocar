package brocar.controller.admin;

import brocar.db.entity.User;
import brocar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showUsers(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("users", userService.findAllOrderByUsername());
        return "admin/user/user";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcuId") User user, Authentication authentication, Model model) {
        model.addAttribute("editUser", user);
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/user/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editModelCar(User user) {
        if(user.getRole().compareTo("-1") == 0) {
            return "-1";
        }
        userService.addAndUpdateUser(user);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteModelCar(@RequestParam("bcuId")User user) {
        userService.delete(user);
        return "redirect:/admin/user";
    }
}

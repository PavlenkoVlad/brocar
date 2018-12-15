package brocar.controller.admin;

import brocar.db.entity.MarkCar;
import brocar.service.MarkCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/markCar")
public class AdminMarkCarController {

    @Autowired
    private MarkCarService markCarService;

    @GetMapping
    public String showAllMarkCars(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("markCars", markCarService.findAllOrderByName());
        return "admin/markCar/markCar";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/markCar/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addMarkCar(MarkCar markCar) {
        MarkCar findMarkCar = markCarService.findByName(markCar.getName());
        if(findMarkCar != null) {
            return "-1";
        }
        markCarService.addAndUpdateMarkCar(markCar);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcmId")MarkCar markCar, Authentication authentication, Model model) {
        model.addAttribute("markCar", markCar);
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/markCar/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editMarkCar(MarkCar markCar) {
        MarkCar findMarkCar = markCarService.findByName(markCar.getName());
        if(findMarkCar != null) {
            return "-1";
        }
        markCarService.addAndUpdateMarkCar(markCar);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteMarkCar(@RequestParam("bcmId")MarkCar markCar) {
        markCarService.delete(markCar);
        return "redirect:/admin/markCar";
    }
}

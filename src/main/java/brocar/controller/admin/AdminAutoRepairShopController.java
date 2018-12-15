package brocar.controller.admin;

import brocar.db.entity.AutoRepairShop;
import brocar.service.AutoRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/ars")
public class AdminAutoRepairShopController {

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @GetMapping
    public String showAllAutoRepairShops(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("autoRepairShops", autoRepairShopService.findAllOrderByName());
        return "admin/ars/ars";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/ars/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addAutoRepairShop(AutoRepairShop autoRepairShop) {
        List<AutoRepairShop> findAutoRepairShops = autoRepairShopService
                .findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(
                        autoRepairShop.getName(),
                        autoRepairShop.getPhone1(),
                        autoRepairShop.getPhone2(),
                        autoRepairShop.getEmail()
                );
        if(findAutoRepairShops.size() != 0) {
            return "-1";
        }
        autoRepairShopService.addAndUpdateAutoRepairShop(autoRepairShop);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcaId")AutoRepairShop autoRepairShop, Authentication authentication, Model model) {
        model.addAttribute("autoRepairShop", autoRepairShop);
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/ars/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editAutoRepairShop(AutoRepairShop autoRepairShop) {
        List<AutoRepairShop> findAutoRepairShops = autoRepairShopService
                .findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(
                        autoRepairShop.getName(),
                        autoRepairShop.getPhone1(),
                        autoRepairShop.getPhone2(),
                        autoRepairShop.getEmail()
                );
        if(findAutoRepairShops.size() > 1) {
            return "-1";
        }
        autoRepairShopService.addAndUpdateAutoRepairShop(autoRepairShop);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteAutoRepairShop(@RequestParam("bcaId")AutoRepairShop autoRepairShop) {
        autoRepairShopService.delete(autoRepairShop);
        return "redirect:/admin/ars";
    }
}

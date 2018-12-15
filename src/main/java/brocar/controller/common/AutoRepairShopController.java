package brocar.controller.common;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ProvService;
import brocar.service.AutoRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ars")
public class AutoRepairShopController {

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @GetMapping
    public String getAutoRepairShop(@RequestParam("bcaId")AutoRepairShop ars, Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("ars", ars);
        model.addAttribute("services", autoRepairShopService.getAllInfoAboutProvServices(ars));
        return "ars";
    }
}

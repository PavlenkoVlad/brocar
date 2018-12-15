package brocar.controller.common;

import brocar.db.entity.*;
import brocar.service.AutoRepairShopService;
import brocar.service.MarkCarService;
import brocar.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class SearchController {

    @Autowired
    private MarkCarService markCarService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @GetMapping("/search")
    public String search(Model model, Authentication authentication) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("markCars", markCarService.findAllOrderByName());
        model.addAttribute("services", serviceService.findAllOrderByName());
        model.addAttribute("autoRepairShopMap", autoRepairShopService.findAllWithMarkCarsAndServices());
        return "search/search";
    }

    @PostMapping("/search")
    public String result(@RequestParam("bcmId") MarkCar markCar,
                           @RequestParam("bcmdId") ModelCar modelCar,
                           @RequestParam("bcsId") Service service,
                           HttpServletRequest request,
                           Authentication authentication,
                           Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        /*
        model.addAttribute("markCars", markCarService.findAllOrderByName());
        model.addAttribute("services", serviceService.findAllOrderByName()); */
        if(modelCar == null) {
            request.getSession().setAttribute("modelCarSelectedValue", -1);
        }
        else {
            request.getSession().setAttribute("modelCarSelectedValue", modelCar.getBcmdId());
        }

        if(markCar == null && modelCar == null && service == null) {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findAllWithMarkCarsAndServices());
        }
        else if(modelCar == null && service == null) {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findByMarkCarWithMarkCarsAndServices(markCar));
        }
        else if(markCar == null && modelCar == null) {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findByServiceWithMarkCarsAndServices(service));
        }
        else if(modelCar == null) {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findByMarkCarAndServiceWithMarkCarsAndServices(markCar, service));
        }
        else if(service == null) {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findByModelCarWithMarkCarsAndServices(modelCar));
        }
        else {
            model.addAttribute("autoRepairShopMap", autoRepairShopService.findByModelCarAndServiceWithMarkCarsAndServices(modelCar, service));
        }
        return "search/result";
    }
}

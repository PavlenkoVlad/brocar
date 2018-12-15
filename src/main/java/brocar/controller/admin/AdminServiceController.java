package brocar.controller.admin;

import brocar.db.entity.Service;
import brocar.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/service")
public class AdminServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public String showAllServices(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("services", serviceService.findAllOrderByName());
        return "admin/service/service";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/service/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addService(Service service) {
        Service findService = serviceService.findByName(service.getName());
        if(findService != null) {
            return "-1";
        }
        serviceService.addAndUpdateService(service);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcsId")Service service, Authentication authentication, Model model) {
        model.addAttribute("service", service);
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/service/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editService(Service service) {
        Service findService = serviceService.findByName(service.getName());
        if(findService != null) {
            return "-1";
        }
        serviceService.addAndUpdateService(service);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteService(@RequestParam("bcsId")Service service) {
        serviceService.delete(service);
        return "redirect:/admin/service";
    }
}

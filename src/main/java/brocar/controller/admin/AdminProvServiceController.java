package brocar.controller.admin;

import brocar.db.entity.ProvService;
import brocar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/provService")
public class AdminProvServiceController {

    @Autowired
    private ProvServiceService provServiceService;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @Autowired
    private ModelCarService modelCarService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public String showAllProvServices(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("provServices", provServiceService.findAll());
        return "admin/provService/provService";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("autoRepairShops", autoRepairShopService.findAllOrderByName());
        model.addAttribute("modelCars", modelCarService.findAllOrderByName());
        model.addAttribute("services", serviceService.findAllOrderByName());
        return "admin/provService/add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String addProvService(int bcaId, int bcmdId, int bcsId, ProvService provService) {
        ProvService findProvService = provServiceService.findByBcaIdAndBcmdIdAndBcsId(bcaId, bcmdId, bcsId);
        if(findProvService != null) {
            return "-1";
        }
        if(bcaId == -1) {
            return "-2";
        }
        if(bcmdId == -1) {
            return "-3";
        }
        if(bcsId == -1) {
            return "-4";
        }
        provServiceService.addProvService(bcaId, bcmdId, bcsId, provService);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(
            @RequestParam("bcaId")int bcaId,
            @RequestParam("bcmdId")int bcmdId,
            @RequestParam("bcsId")int bcsId,
            Authentication authentication, Model model) {
        model.addAttribute("provService", provServiceService.findByBcaIdAndBcmdIdAndBcsId(bcaId, bcmdId, bcsId));
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/provService/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editProvService(int bcaId, int bcmdId, int bcsId, ProvService provService) {
        if(bcaId == -1) {
            return "-1";
        }
        if(bcmdId == -1) {
            return "-2";
        }
        if(bcsId == -1) {
            return "-3";
        }
        provServiceService.updateProvService(bcaId, bcmdId, bcsId, provService);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteTimetable(@RequestParam("bcaId")int bcaId,
                                  @RequestParam("bcmdId")int bcmdId,
                                  @RequestParam("bcsId")int bcsId) {
        provServiceService.delete(provServiceService.findByBcaIdAndBcmdIdAndBcsId(bcaId, bcmdId, bcsId));
        return "redirect:/admin/provService";
    }

}

package brocar.controller.admin;

import brocar.db.entity.Timetable;
import brocar.service.AutoRepairShopService;
import brocar.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/timetable")
public class AdminTimetableController {

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @GetMapping
    public String showAllTimetables(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("timetables", timetableService.findAllOrderByBcaId());
        return "admin/timetable/timetable";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        model.addAttribute("autoRepairShops", autoRepairShopService.findAllOrderByName());
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/timetable/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addTimetable(Timetable timetable) {
        Timetable findTimetable = timetableService.findByBcaId(timetable.getBcaId());
        if(findTimetable != null) {
            return "-1";
        }
        timetableService.addTimetable(timetable);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcaId")Timetable timetable, Authentication authentication, Model model) {
        model.addAttribute("timetable", timetable);
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/timetable/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editTimetable(Timetable timetable) {
        timetableService.updateTimetable(timetable);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteTimetable(@RequestParam("bcaId")Timetable timetable) {
        timetableService.delete(timetable);
        return "redirect:/admin/timetable";
    }
}

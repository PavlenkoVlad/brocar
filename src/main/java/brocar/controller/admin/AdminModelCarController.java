package brocar.controller.admin;

import brocar.db.entity.ModelCar;
import brocar.service.MarkCarService;
import brocar.service.ModelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/modelCar")
public class AdminModelCarController {

    @Autowired
    private ModelCarService modelCarService;

    @Autowired
    private MarkCarService markCarService;

    @GetMapping
    public String showAllModelCars(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        model.addAttribute("modelCars", modelCarService.findAllOrderByName());
        return "admin/modelCar/modelCar";
    }

    @GetMapping("/add")
    public String addForm(Authentication authentication, Model model) {
        model.addAttribute("user", authentication);
        model.addAttribute("markCars", markCarService.findAllOrderByName());
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/modelCar/add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String addModelCar(int bcmId, ModelCar modelCar) {
        ModelCar findModelCar = modelCarService.findByName(modelCar.getName());
        if(findModelCar != null) {
            return "-1";
        }
        if(bcmId == -1) {
            return "-2";
        }
        modelCarService.addModelCar(bcmId, modelCar);
        return "0";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("bcmdId")ModelCar modelCar, Authentication authentication, Model model) {
        model.addAttribute("modelCar", modelCar);
        model.addAttribute("markCars", markCarService.findAllOrderByName());
        model.addAttribute("user", authentication);
        if(authentication != null) {
            model.addAttribute("role", authentication.getAuthorities().toArray()[0]);
        }
        return "admin/modelCar/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editModelCar(int bcmId, ModelCar modelCar) {
        if(bcmId == -1) {
            return "-1";
        }
        modelCarService.updateModelCar(bcmId, modelCar);
        return "0";
    }

    @GetMapping("/delete")
    public String deleteModelCar(@RequestParam("bcmdId")ModelCar modelCar) {
        modelCarService.delete(modelCar);
        return "redirect:/admin/modelCar";
    }

}

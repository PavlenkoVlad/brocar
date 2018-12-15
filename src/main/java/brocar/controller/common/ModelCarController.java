package brocar.controller.common;

import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;
import brocar.service.ModelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("/modelCar")
public class ModelCarController {

    @Autowired
    private ModelCarService modelCarService;

    @GetMapping("/getModelsByMarkId")
    @ResponseBody
    public List<ModelCar> getModelsByMarkId(@RequestParam("bcmId") MarkCar markCar) {
        if(markCar == null)
            return null;
        return modelCarService.findAllByMarkCar(markCar);
    }
}

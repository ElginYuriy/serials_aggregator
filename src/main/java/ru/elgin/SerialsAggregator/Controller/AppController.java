package ru.elgin.SerialsAggregator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.elgin.SerialsAggregator.Entity.Serial;
import ru.elgin.SerialsAggregator.Services.SerialService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    SerialService serialService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        List<Serial> serialList = serialService.getAll();
        model.addAttribute("serialList", serialList);
        return "index";
    }
}

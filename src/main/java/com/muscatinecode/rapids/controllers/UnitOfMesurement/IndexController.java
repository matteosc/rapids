package com.muscatinecode.rapids.controllers.UnitOfMesurement;

import com.muscatinecode.rapids.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class IndexController {

    private final UnitOfMeasureService unitOfMeasureService;

    public IndexController(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }


    @RequestMapping({"uom", "uom/", "uom/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("uoms", unitOfMeasureService.listAllUoms());

        return "uom/index";
    }
}

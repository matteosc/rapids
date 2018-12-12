package com.muscatinecode.rapids.controllers.UnitOfMesurement;

import com.muscatinecode.rapids.commands.RecipeCommand;
import com.muscatinecode.rapids.commands.UnitOfMeasureCommand;
import com.muscatinecode.rapids.domain.UnitOfMeasure;
import com.muscatinecode.rapids.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
@Controller
public class UnitOfMesurementController {

    private final UnitOfMeasureService unitOfMeasureService;

    public UnitOfMesurementController(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }
/*
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

    }
*/
    @GetMapping
    @RequestMapping("/uom/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("uom", unitOfMeasureService.findById(new Long(id)));

        return "uom/show";
    }

    @GetMapping
    @RequestMapping("uom/new")
    public String newUom(Model model) {
        model.addAttribute("unitofmesure", new UnitOfMeasureCommand());

        return "uom/uomform";
    }

    @GetMapping
    @RequestMapping("uom/{id}/update")
    public String updateUom(@PathVariable String id, Model model) {
        UnitOfMeasureCommand uom=unitOfMeasureService.findCommandById(Long.valueOf(id));
       System.out.println("id in comm"+ uom.getId());
        model.addAttribute("unitofmesure", uom);
        return "uom/uomform";
    }

    @PostMapping("uom/")
    public String saveOrUpdate(@ModelAttribute UnitOfMeasureCommand command) {
        System.out.println("id in post "+command.getId());
        UnitOfMeasureCommand savedCommand = unitOfMeasureService.saveUnitOfMeasureCommand(command);

        return "redirect:/uom/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("uom/{id}/delete")
    public String deleteById(@PathVariable String id) {

        log.debug("Deleting id: " + id);

        unitOfMeasureService.deleteById(Long.valueOf(id));
        return "redirect:/uom/";
    }

    @RequestMapping({"uom/find"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("uom", new UnitOfMeasure());

        return "uom/find";
    }


}

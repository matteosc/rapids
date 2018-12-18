package com.muscatinecode.rapids.controllers.UnitOfMesurement;

import com.muscatinecode.rapids.commands.RecipeCommand;
import com.muscatinecode.rapids.commands.UnitOfMeasureCommand;
import com.muscatinecode.rapids.domain.UnitOfMeasure;
import com.muscatinecode.rapids.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
@Controller
public class UnitOfMesurementController {
@Autowired
    private  UnitOfMeasureService unitOfMeasureService;




    @RequestMapping({"uom", "uom/", "uom/index"})
    public ModelAndView getIndexPage() {
       ModelAndView modelAndView=new ModelAndView("uom/index");
        modelAndView.addObject("uoms", unitOfMeasureService.listAllUoms());

        return modelAndView;
    }

    @RequestMapping("uom/list")
    public ModelAndView getListPage() {
        ModelAndView modelAndView=new ModelAndView("uom/list");
        modelAndView.addObject("uoms", unitOfMeasureService.listAllUoms());

        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/uom/{id}/show.html")
    public ModelAndView showById(@PathVariable String id) {
       ModelAndView modelAndView=new ModelAndView("uom/show");
modelAndView.addObject("uom",unitOfMeasureService.findCommandById(new Long(id)));

        return modelAndView;
    }



    @RequestMapping(value = "uom/new.html", method = RequestMethod.GET)
    public ModelAndView getUomFormNew() {
        ModelAndView modelAndView=new ModelAndView("uom/uomform");
modelAndView.addObject("unitofmesure", new UnitOfMeasureCommand());
        return modelAndView;
    }


    @RequestMapping(value = "uom/{id}/update.html", method = RequestMethod.GET)
    public ModelAndView getUomFormUpdate(@PathVariable String id) {
        ModelAndView modelAndView=new ModelAndView("uom/uomform");

        modelAndView.addObject("unitofmesure", unitOfMeasureService.findCommandById(new Long(id)));
        return modelAndView;
    }

    @GetMapping
    @RequestMapping("uom/{id}/delete.html")
    public String deleteById(@PathVariable String id) {



        unitOfMeasureService.deleteById(Long.valueOf(id));
        return "redirect:/uom/";
    }


    @RequestMapping(value = "/uom/", method = RequestMethod.POST)
    public ModelAndView submitUomForm(@ModelAttribute("uom1") UnitOfMeasureCommand uom1) {
       System.out.println("im in");
        UnitOfMeasureCommand savedCommand = unitOfMeasureService.saveUnitOfMeasureCommand(uom1);
        System.out.println("id "+savedCommand.getId());
        ModelAndView modelAndView=new ModelAndView(  "redirect:/uom/"+savedCommand.getId() + "/show.html");

        return modelAndView;
    }
}

package com.muscatinecode.rapids.controllers.Allergen;

import com.muscatinecode.rapids.commands.AllergenCommand;

import com.muscatinecode.rapids.domain.Allergen;

import com.muscatinecode.rapids.services.AllergenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
@Controller
public class AllergenController {
 private final AllergenService service;

    public AllergenController(AllergenService service) {
        this.service = service;
    }
/*
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

    }
*/

    @RequestMapping({"allergen", "allergen/", "allergen/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("allergens", service.listAllAllergensCommands());

        return "allergen/index";
    }

    @RequestMapping({"allergen/list"})
    public String getAllergenList(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("allergens", service.listAllAllergensCommands());

        return "allergen/list";
    }

    @GetMapping
    @RequestMapping("/allergen/{id}/show")
    public String showById(@PathVariable String id, Model model) {
System.out.println("all "+service.findById(new Long(id)));
        model.addAttribute("allergen", service.findById(new Long(id)));

        return "allergen/show";
    }

    @GetMapping
    @RequestMapping("allergen/new")
    public String newallergen(Model model) {
        model.addAttribute("allergen", new AllergenCommand());

        return "allergen/allergenform";
    }

    @GetMapping
    @RequestMapping("allergen/{id}/update")
    public String updateallergen(@PathVariable String id, Model model) {
        AllergenCommand allergen=service.findCommandById(Long.valueOf(id));

        model.addAttribute("allergen", allergen);
        return "allergen/allergenform";
    }

    @PostMapping("allergen/")
    public String saveOrUpdate(@ModelAttribute AllergenCommand command) {
System.out.println("im in post all");
        AllergenCommand savedCommand = service.saveAllergenCommand(command);

        return "redirect:/allergen/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("allergen/{id}/delete")
    public String deleteById(@PathVariable String id) {

        log.debug("Deleting id: " + id);

        service.deleteById(Long.valueOf(id));
        return "redirect:/allergen/";
    }

    @RequestMapping({"allergen/find"})
    public String getFindPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("allergen", new Allergen());

        return "allergen/find";
    }


}

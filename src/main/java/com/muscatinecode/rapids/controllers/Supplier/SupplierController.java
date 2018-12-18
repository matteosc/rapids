package com.muscatinecode.rapids.controllers.Supplier;

import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.services.SupplierService;
import com.muscatinecode.rapids.services.SupplierServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
@Controller
public class SupplierController {
 private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }
@ModelAttribute
    public void addCommonObjects(Model model1){
model1.addAttribute("suppliers",service.listAllSuppliers());

    }

    @RequestMapping({"/supplier", "/supplier/", "/supplier/index"})
    public String getIndexPage(Model model) {



        return "supplier/index";
    }

    @RequestMapping({"supplier/list"})
    public ModelAndView getSupplierList( ) {

ModelAndView modelAndView1=new ModelAndView("/supplier/list");


        return modelAndView1;
    }

    @GetMapping
    @RequestMapping("/supplier/{id}/show")
    public ModelAndView showById(@PathVariable String id ) {
 ModelAndView modelAndView1=new ModelAndView("/supplier/show");
        modelAndView1.addObject("supplier", service.findById(new Long(id)));

        return modelAndView1;
    }

    @GetMapping
    @RequestMapping("/supplier/{id}/invoices")
    public ModelAndView showSupplierInvoices(@PathVariable String id ) {
        ModelAndView modelAndView1=new ModelAndView("/supplier/supplierInvoices");
        modelAndView1.addObject("supplier", service.findById(new Long(id)));

        return modelAndView1;
    }

    @GetMapping
    @RequestMapping("/supplier/{id}/orders")
    public ModelAndView showSupplierOrders(@PathVariable String id ) {
        ModelAndView modelAndView1=new ModelAndView("/supplier/supplierOrders");
        modelAndView1.addObject("supplier", service.findById(new Long(id)));

        return modelAndView1;
    }

    /////////////////////////////////////////////////////////////////
    @GetMapping
    @RequestMapping("supplier/new")
    public String newSupplier(Model model) {
        model.addAttribute("supplier", new SupplierCommand());

        return "supplier/supplierform";
    }

    @GetMapping
    @RequestMapping("supplier/{id}/update")
    public String updateSupplier(@PathVariable String id, Model model) {
        SupplierCommand supplier=service.findCommandById(Long.valueOf(id));

        model.addAttribute("supplier", supplier);
        return "supplier/supplierform";
    }

    @PostMapping("supplier/")
    public String saveOrUpdate(@ModelAttribute SupplierCommand command) {
System.out.println("im in post all");
        SupplierCommand savedCommand = service.saveSupplierCommand(command);
        System.out.println("im in post all"+ savedCommand.getId());
       return "redirect:/supplier/" + savedCommand.getId() + "/show";

    }

    @GetMapping
    @RequestMapping("supplier/{id}/delete")
    public String deleteById(@PathVariable String id) {

        log.debug("Deleting id: " + id);

        service.deleteById(Long.valueOf(id));
        return "redirect:/supplier/";
    }
}

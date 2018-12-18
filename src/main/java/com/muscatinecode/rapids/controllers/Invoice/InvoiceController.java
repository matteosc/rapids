package com.muscatinecode.rapids.controllers.Invoice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class InvoiceController {

    @RequestMapping({"invoice/list"})
    public String getSupplierList(Model model) {




        return "supplier/list";
    }

}

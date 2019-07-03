package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    //Editing a current Post
    @GetMapping("/incomeAndTax")
    public String getInfo() {
        return "incomeAndTax";
    }

    @PostMapping("/incomeAndTax")
    public String calculate(
            @RequestParam(name = "income") long income,
            @RequestParam(name = "state") String state) {

        taxService.incomeNotify
                ("Taxes", "Your Monthly income is " +
                        income / 12 + "and annual income is " +
                        income + ". " +
                        "Your expected taxes are blank for the state" + state );
        return "redirect:/incomeAndTax";
    }

}

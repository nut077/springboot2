package com.freedom.nut.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelFreedom {
    @GetMapping("/excel")
    public ModelAndView excel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("excel", "<table><tr><td>555</td></tr></table>");
        modelAndView.setViewName("excel");
        return modelAndView;
    }
}

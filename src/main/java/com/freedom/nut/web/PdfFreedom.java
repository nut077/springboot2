package com.freedom.nut.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PdfFreedom {
    @GetMapping("/pdf")
    public ModelAndView pdf() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pdf");
        modelAndView.addObject("pdf", "<table><tr><td>555</td></tr></table>");
        return modelAndView;
    }
}

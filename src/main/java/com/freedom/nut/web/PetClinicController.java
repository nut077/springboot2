package com.freedom.nut.web;

import com.freedom.nut.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetClinicController {

    private PetClinicService petClinicService;

    @Autowired
    public PetClinicController(PetClinicService petClinicService) {
        this.petClinicService = petClinicService;
    }

    @GetMapping({"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/pcs")
    @ResponseBody
    public String welcome() {
        return "Welcome to PetClinic World!";
    }

    @GetMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("owners", petClinicService.findOwners());
        modelAndView.setViewName("owners");
        return modelAndView;
    }

}

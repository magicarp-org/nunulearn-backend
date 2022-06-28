package me.chanwookim.nunulearnbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/docs")
public class swaggerController {
    @GetMapping
    public String api() {
        return "redirect:/swagger-ui/index.html";
    }
}

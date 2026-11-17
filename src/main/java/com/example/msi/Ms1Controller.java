package com.example.msi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1")
public class Ms1Controller {

    private final AdditionService additionService;

    public Ms1Controller(AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return "addition=" + additionService.add(a, b);
    }
}
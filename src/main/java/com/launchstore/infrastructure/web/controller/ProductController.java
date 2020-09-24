package com.launchstore.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping(path = {"/products/create"})
    public String createProduct(){
        return "product/create";
    }
}

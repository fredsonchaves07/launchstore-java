package com.launchstore.infrastructure.web.controller;

import com.launchstore.application.ProductService;
import com.launchstore.domain.product.Product;
import com.launchstore.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {
    private IndexController indexController = new IndexController();

    @Autowired
    private ProductService productService;

    @GetMapping(path = {"/products/create"})
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping(path = {"/products"})
    public String saveProduct(@ModelAttribute("product") @Valid Product product, Errors errors, Model model){
        System.out.println(errors.hasErrors());
        System.out.println(errors.getAllErrors());
        if(!errors.hasErrors()){
            productService.saveProduct(product);

            model.addAttribute("msg", "Produto cadastrado com sucesso!");

        }

        return "products/" + product.getId();
    }

    @GetMapping(path = {"/products/:id"})
    public String showProduct(@ModelAttribute("product") Model model){
        return "product/show";
    }
}

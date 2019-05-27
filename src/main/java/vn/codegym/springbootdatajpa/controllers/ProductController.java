package vn.codegym.springbootdatajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.springbootdatajpa.dao.ProductDaoService;
import vn.codegym.springbootdatajpa.repositories.ProductRepository;

@Controller
public class ProductController {
    @Autowired ProductDaoService productDaoService;
    @Autowired ProductRepository productRepository;

    @GetMapping("/product")
    public String show(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "list-product";
    }
}

package ru.dias.spring1boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dias.spring1boot.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products-list";
    }

    @GetMapping("/filter")
    public String showFilterData(Model model,
                                 @RequestParam(required = false, name = "min_price") Double min,
                                 @RequestParam(required = false, name = "max_price") Double max) {
        model.addAttribute("products", productService.findAllFilter(min, max));
        return "products-list";
    }

}

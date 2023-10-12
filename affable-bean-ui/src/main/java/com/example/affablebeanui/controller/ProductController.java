package com.example.affablebeanui.controller;

import com.example.affablebeanui.data.CategoryDto;
import com.example.affablebeanui.data.ProductDto;
import com.example.affablebeanui.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String listProducts(@RequestParam("id") int id, Model model) {
        model.addAttribute("products",
                productService.findProductsByCategoryId(id));
        return "products";
    }

    @GetMapping("/add-cart")
    public String addToCat(@RequestParam("id") int id) {
        ProductDto productDto =
                productService.findProductByProductId(id);
        productService.addToCart(productDto);
        return "redirect:/ui/products?id="+productDto.getCategory_id();
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<CategoryDto> test() {
        return productService.listAllCategory();
    }

    @ModelAttribute("cartSize")
    public int cartSize() {
        return productService.cartSize();
    }
}

package com.example.affablebeanui.config;

import com.example.affablebeanui.data.CategoryDto;
import com.example.affablebeanui.data.ProductDto;
import jdk.jfr.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${product.backend.url}",
        value = "product-feign-client",
        path = "/backend")
public interface ProductFeignClient {

    @GetMapping("/product/product-list")
    public List<ProductDto> findAllProducts();

    @GetMapping("/product/category-list")
    public List<CategoryDto> findAllCategory();
}

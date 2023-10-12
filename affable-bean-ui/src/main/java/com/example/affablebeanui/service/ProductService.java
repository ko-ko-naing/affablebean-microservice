package com.example.affablebeanui.service;

import com.example.affablebeanui.config.ProductFeignClient;
import com.example.affablebeanui.data.CartBean;
import com.example.affablebeanui.data.CartItem;
import com.example.affablebeanui.data.CategoryDto;
import com.example.affablebeanui.data.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CartBean cartBean;
    private final ProductFeignClient productFeignClient;

    public void addToCart(ProductDto productDto) {
        cartBean.addToCart(toCartItem(productDto));
    }

    public int cartSize() {
        return cartBean.cartSize();
    }

    private CartItem toCartItem(ProductDto productDto) {
        return new CartItem(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                0
        );
    }

    public ProductDto findProductByProductId(int id) {
        return listAllProduct()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                        id + "Not Found"
        ));
    }

    public List<ProductDto> listAllProduct() {
        return productFeignClient.findAllProducts();
    }

    public List<CategoryDto> listAllCategory() {
        return productFeignClient.findAllCategory();
    }

    public List<ProductDto> findProductsByCategoryId(int id) {
        return listAllProduct()
                .stream()
                .filter(p -> p.getCategory_id() == id)
                .collect(Collectors.toList());

    }

}

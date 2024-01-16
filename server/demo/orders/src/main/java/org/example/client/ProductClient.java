package org.example.client;

import org.example.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "nacos-productServer")
public interface ProductClient {
    @GetMapping("/product/getProductList")
    List<ProductDto> getProductList();
}

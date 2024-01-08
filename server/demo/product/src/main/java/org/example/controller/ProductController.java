package org.example.controller;

import org.example.mapper.ProductMapper;
import org.example.po.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/getproductList")
    public List<ProductPo> getProductList(){
        List<ProductPo> productPos = productMapper.selectList(null);
        return productPos;
    }
}

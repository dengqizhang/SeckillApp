package org.example.controller;

import org.example.mapper.ProductMapper;
import org.example.po.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询全部商品
     * @return
     */
    @GetMapping("/getproductList")
    public List<ProductPo> getProductList(){
        List<ProductPo> productPos = productMapper.selectList(null);
        return productPos;
    }

    @PostMapping("/updateProduct")
    public ProductPo updateProduct(){
        
    }
}

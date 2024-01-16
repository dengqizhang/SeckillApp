package org.example.controller;

import org.example.dto.OrderItemsDto;
import org.example.dto.ProductDto;
import org.example.mapper.ProductMapper;
import org.example.po.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
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
    @GetMapping("/getProductList")
    public List<ProductDto> getProductList(){
        List<ProductDto> productPos = productMapper.selectList(null);
        return productPos;
    }

    @PostMapping("/reduceInventory")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ProductDto> updateProduct(@RequestBody List<OrderItemsDto> orderItemsDtos){
        try{
            //创建商品项集合
           List<ProductDto> updateProducts = new ArrayList<>();
           //根据id循环传递的商品项进行操作
           for (OrderItemsDto orderItem : orderItemsDtos){
               //根据productId查询商品信息
               ProductDto product = productMapper.selectByIdProduct(orderItem.getProductId());
               //取出当前查询到的product对象的id
               int productid = product.getProductID();
               //更新商品信息
               int i = productMapper.updateStockById(productid, orderItem.getQuantity());
               ProductDto updateProduct = productMapper.selectByIdProduct(productid); //重新查询数据库获取更新后的数据
               updateProducts.add(updateProduct);
           }
            return updateProducts;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }


    }
}

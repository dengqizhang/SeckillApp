package org.example.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
@TableName("product")
public class ProductDto {

    private int productID; //商品表id
    private String name; //商品姓名
    private String description; //商品描述
    private BigDecimal price; //商品价格
    private int stock; //商品库存
    private int soldQuantity; //已售数量
    private int seckillStatus; //秒杀状态

}

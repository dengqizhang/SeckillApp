package org.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@TableName("`product`")
public class ProductPo {

    private int productID; //商品表id
    private String name; //商品姓名
    private String description; //商品描述
    private BigDecimal price; //商品价格
    private int stock; //商品库存
    private int soldQuantity; //已售数量
    private int seckillStatus; //秒杀状态

}

package org.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@TableName("`order_items`")
public class OrderItemsPo {
    private int orderId; //订单表id
    private int productId; //商品id
    private int quantity; //商品数量
}

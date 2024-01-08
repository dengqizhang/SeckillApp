package org.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@TableName("`orders`")
public class Orders {
    private int orderId; //订单表id
    private int userId; //用户id
    private int productId; //商品id
    private int quantity; //当前商品在订单内的数量
    private String status; //状态
    private String createTime;  //生成订单时间


}

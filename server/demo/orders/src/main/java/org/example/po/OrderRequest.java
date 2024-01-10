package org.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderRequest {
    private int orderId; //订单表id
    private int userId; //用户id
    private String status; //状态
    private Date createTime; //订单生成时间
    private List<OrderItemsPo> itemsPos; //订单里的商品项列表
}

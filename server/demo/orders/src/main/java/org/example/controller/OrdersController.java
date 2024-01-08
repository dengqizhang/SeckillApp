package org.example.controller;

import org.example.mapper.OrdersMapper;
import org.example.po.Orders;
import org.example.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 查询所有订单
     * @return List<Orders>
     */
    @GetMapping("/getorders")
    public List<Orders> getorders(){
        List<Orders> ordersList = ordersMapper.selectList(null);
        return ordersList;
    }

    /**
     * 新增订单
     * @param orders
     * @return ApiResponse
     */
    @PostMapping("/addorders")
    @ResponseBody
    public ApiResponse<String> addorders(@RequestBody Orders orders){
        try {
            Orders order = new Orders();
            order.setOrderId(orders.getOrderId());
            order.setUserId(orders.getUserId());
            order.setProductId(orders.getProductId());
            order.setQuantity(orders.getQuantity());
            order.setStatus(orders.getStatus());
            order.setCreateTime(orders.getCreateTime());
            int insert = ordersMapper.insert(order);
            System.out.println(insert);

            if (insert == 1){
                return new ApiResponse<>(200,"创建订单成功",null);

            }else {
                return new ApiResponse<>(400,"创建订单失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(500,"其他异常",null);
        }


    }
}

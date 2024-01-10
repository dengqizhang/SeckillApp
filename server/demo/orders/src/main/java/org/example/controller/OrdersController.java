package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.OrdersItemMapper;
import org.example.mapper.OrdersMapper;
import org.example.po.OrderItemsPo;
import org.example.po.OrderRequest;
import org.example.po.Orders;
import org.example.util.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersItemMapper ordersItemMapper;
    /**
     * 查询所有订单
     * @return List<Orders>
     */
    @GetMapping("/getorders")
    public List<Orders> getorders(){
        List<Orders> ordersList = ordersMapper.selectList(null);
        return ordersList;
    }

    @PostMapping("/deleteOrdersandItems")
    public ApiResponse<String> deleteOrdersAndItems(@RequestParam("orderId") Integer orderId){
        try{
            //删除订单明细
            QueryWrapper<OrderItemsPo> wrapper = new QueryWrapper<>();
            wrapper.eq("orderId",orderId);
            int itemsdelete = ordersItemMapper.delete(wrapper);

            //删除订单
            int ordersDelete = ordersMapper.deleteById(orderId);

            System.out.println(itemsdelete);
            System.out.println(ordersDelete);
            if (itemsdelete > 0 && ordersDelete == 1 ){
                return new ApiResponse<>(200,"取消订单成功",null);
            }else {
                return new ApiResponse<>(400,"取消订单失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(500,"取消订单异常",null);
        }

    }

    /**
     * 新增订单
     *
     * @param orderRequest
     * @return ApiResponse
     */
    @PostMapping("/addorders")
    @ResponseBody
    public ApiResponse<OrderRequest> addorders(@RequestBody OrderRequest orderRequest){
        try {
            Orders order = new Orders();
            BeanUtils.copyProperties(orderRequest,order);

            int insert = ordersMapper.insert(order);
            System.out.println(insert);

            if (insert == 1){
                int orderId = order.getOrderId(); //获取生成的订单id
                System.out.println(orderId);
                //遍历商品列表，创建订单项
                for (OrderItemsPo item : orderRequest.getItemsPos()){
                    System.out.println(item);
                    OrderItemsPo orderItemsPo = new OrderItemsPo();
                    orderItemsPo.setOrderId(orderId);
                    orderItemsPo.setProductId(item.getProductId());
                    orderItemsPo.setQuantity(item.getQuantity());
                    ordersItemMapper.insert(orderItemsPo);


                }
                Orders orders = ordersMapper.selectById(orderId);
                System.out.println(orders);


                QueryWrapper<OrderItemsPo> wrapper = new QueryWrapper<>();
                wrapper.eq("orderId",orderId);
                List<OrderItemsPo> orderItemsPos = ordersItemMapper.selectList(wrapper);
                System.out.println(orderItemsPos);


                OrderRequest orderRequest1 = new OrderRequest();
                BeanUtils.copyProperties(orders,orderRequest1);
                orderRequest1.setItemsPos(orderItemsPos);
                return new ApiResponse<OrderRequest>(200,"创建订单成功",orderRequest1);

            }else {
                return new ApiResponse<>(400,"创建订单失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse<>(500,"其他异常",null);
        }


    }
}

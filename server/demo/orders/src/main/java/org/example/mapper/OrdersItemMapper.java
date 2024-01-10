package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.po.OrderItemsPo;

@Mapper
public interface OrdersItemMapper extends BaseMapper<OrderItemsPo> {
}

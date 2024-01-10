package org.example.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@TableName("`orders`")
public class Orders {
    @TableId(type = IdType.AUTO)
    private int orderId; //订单表id
    private int userId; //用户id
    private String status; //状态
    private Date createTime;  //生成订单时间


}

package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.dto.ProductDto;
import org.example.po.ProductPo;
@Mapper
public interface ProductMapper extends BaseMapper<ProductDto> {
    //根据id查询product对象
    @Select("SELECT * FROM product WHERE productId = #{id}")
    ProductDto selectByIdProduct(int id);


    //根据id更改product对象
    @Update("UPDATE product SET stock = stock - #{quantity} , soldQuantity = soldQuantity - #{quantity} WHERE productId = #{id}")
    int updateStockById(@Param("id") int id,@Param("quantity") int quantity);
}

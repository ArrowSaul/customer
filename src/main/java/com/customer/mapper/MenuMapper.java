package com.customer.mapper;


import com.customer.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 查询菜单
     * @return
     */
    List<Menu> list();
    @Select("select * from menu where id = #{id}")
    Menu queryById(Long id);
}

package com.itdr.mappers;

import com.itdr.pojo.Orders_item;

public interface Orders_itemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders_item record);

    int insertSelective(Orders_item record);

    Orders_item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders_item record);

    int updateByPrimaryKey(Orders_item record);
}
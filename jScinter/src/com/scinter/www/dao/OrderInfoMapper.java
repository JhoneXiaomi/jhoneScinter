package com.scinter.www.dao;

import com.scinter.www.model.OrderInfo;
import com.scinter.www.model.OrderInfoExample;
import java.util.List;

public interface OrderInfoMapper {
    int countByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}
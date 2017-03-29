package com.scinter.www.dao;

import com.scinter.www.model.HotBuilding;
import com.scinter.www.model.HotBuildingExample;
import java.util.List;

public interface HotBuildingMapper {
    int countByExample(HotBuildingExample example);

    int deleteByPrimaryKey(Integer bulidingId);

    int insert(HotBuilding record);

    int insertSelective(HotBuilding record);

    List<HotBuilding> selectByExample(HotBuildingExample example);

    HotBuilding selectByPrimaryKey(Integer bulidingId);

    int updateByPrimaryKeySelective(HotBuilding record);

    int updateByPrimaryKey(HotBuilding record);
}
package com.scinter.www.dao;

import com.scinter.www.model.Repair;
import com.scinter.www.model.RepairExample;
import java.util.List;

public interface RepairMapper {
    int countByExample(RepairExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Repair record);

    int insertSelective(Repair record);

    List<Repair> selectByExample(RepairExample example);

    Repair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}
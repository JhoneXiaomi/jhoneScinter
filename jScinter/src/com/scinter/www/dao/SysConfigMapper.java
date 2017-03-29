package com.scinter.www.dao;

import com.scinter.www.model.SysConfig;
import com.scinter.www.model.SysConfigExample;
import java.util.List;

public interface SysConfigMapper {
    int countByExample(SysConfigExample example);

    int deleteByPrimaryKey(Integer configId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(SysConfigExample example);

    SysConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}
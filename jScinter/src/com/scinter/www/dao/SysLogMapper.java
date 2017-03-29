package com.scinter.www.dao;

import com.scinter.www.model.SysLog;
import com.scinter.www.model.SysLogExample;
import java.util.List;

public interface SysLogMapper {
    int countByExample(SysLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}
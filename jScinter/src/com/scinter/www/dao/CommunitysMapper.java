package com.scinter.www.dao;

import com.scinter.www.model.Communitys;
import com.scinter.www.model.CommunitysExample;
import java.util.List;

public interface CommunitysMapper {
    int countByExample(CommunitysExample example);

    int deleteByPrimaryKey(Integer communityId);

    int insert(Communitys record);

    int insertSelective(Communitys record);

    List<Communitys> selectByExample(CommunitysExample example);

    Communitys selectByPrimaryKey(Integer communityId);

    int updateByPrimaryKeySelective(Communitys record);

    int updateByPrimaryKey(Communitys record);
}
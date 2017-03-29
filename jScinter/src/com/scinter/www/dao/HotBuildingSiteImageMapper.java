package com.scinter.www.dao;

import com.scinter.www.model.HotBuildingSiteImage;
import com.scinter.www.model.HotBuildingSiteImageExample;
import java.util.List;

public interface HotBuildingSiteImageMapper {
    int countByExample(HotBuildingSiteImageExample example);

    int deleteByPrimaryKey(Integer imageId);

    int insert(HotBuildingSiteImage record);

    int insertSelective(HotBuildingSiteImage record);

    List<HotBuildingSiteImage> selectByExample(HotBuildingSiteImageExample example);

    HotBuildingSiteImage selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(HotBuildingSiteImage record);

    int updateByPrimaryKey(HotBuildingSiteImage record);
}
package com.scinter.www.dao;

import com.scinter.www.model.CaseShowImage;
import com.scinter.www.model.CaseShowImageExample;
import java.util.List;

public interface CaseShowImageMapper {
    int countByExample(CaseShowImageExample example);

    int deleteByPrimaryKey(Integer imageId);

    int insert(CaseShowImage record);

    int insertSelective(CaseShowImage record);

    List<CaseShowImage> selectByExample(CaseShowImageExample example);

    CaseShowImage selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(CaseShowImage record);

    int updateByPrimaryKey(CaseShowImage record);
}
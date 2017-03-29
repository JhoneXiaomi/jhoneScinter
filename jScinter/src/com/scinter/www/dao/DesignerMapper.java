package com.scinter.www.dao;

import com.scinter.www.model.Designer;
import com.scinter.www.model.DesignerExample;
import java.util.List;

public interface DesignerMapper {
    int countByExample(DesignerExample example);

    int deleteByPrimaryKey(Integer designerId);

    int insert(Designer record);

    int insertSelective(Designer record);

    List<Designer> selectByExample(DesignerExample example);

    Designer selectByPrimaryKey(Integer designerId);

    int updateByPrimaryKeySelective(Designer record);

    int updateByPrimaryKey(Designer record);
}
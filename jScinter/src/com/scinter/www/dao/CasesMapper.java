package com.scinter.www.dao;

import com.scinter.www.model.Cases;
import com.scinter.www.model.CasesExample;
import java.util.List;

public interface CasesMapper {
    int countByExample(CasesExample example);

    int deleteByPrimaryKey(Integer caseId);

    int insert(Cases record);

    int insertSelective(Cases record);

    List<Cases> selectByExample(CasesExample example);

    Cases selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(Cases record);

    int updateByPrimaryKey(Cases record);
}
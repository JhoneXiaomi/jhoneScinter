package com.scinter.www.dao;

import com.scinter.www.model.Module;
import com.scinter.www.model.ModuleExample;
import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}
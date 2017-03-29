package com.scinter.www.dao;

import com.scinter.www.model.Role;
import com.scinter.www.model.RoleExample;
import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
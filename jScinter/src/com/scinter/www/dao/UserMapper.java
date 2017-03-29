package com.scinter.www.dao;

import com.scinter.www.model.User;
import com.scinter.www.model.UserExample;
import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    User selectForloginLowerCase(User record);
    
    User selectForlogin(User record);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
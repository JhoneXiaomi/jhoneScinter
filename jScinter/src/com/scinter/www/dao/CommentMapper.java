package com.scinter.www.dao;

import com.scinter.www.model.Comment;
import com.scinter.www.model.CommentExample;
import java.util.List;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}
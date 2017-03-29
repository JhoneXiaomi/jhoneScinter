package com.scinter.www.dao;

import com.scinter.www.model.IntegratedPackage;
import com.scinter.www.model.IntegratedPackageExample;
import java.util.List;

public interface IntegratedPackageMapper {
    int countByExample(IntegratedPackageExample example);

    int deleteByPrimaryKey(Integer integratedPackageId);

    int insert(IntegratedPackage record);

    int insertSelective(IntegratedPackage record);

    List<IntegratedPackage> selectByExample(IntegratedPackageExample example);

    IntegratedPackage selectByPrimaryKey(Integer integratedPackageId);

    int updateByPrimaryKeySelective(IntegratedPackage record);

    int updateByPrimaryKey(IntegratedPackage record);
}
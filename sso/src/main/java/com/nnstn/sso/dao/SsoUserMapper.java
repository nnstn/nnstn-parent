package com.nnstn.sso.dao;

import java.util.List;

import com.nnstn.common.po.SsoUser;

public interface SsoUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SsoUser record);

    int insertSelective(SsoUser record);

    SsoUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SsoUser record);

    int updateByPrimaryKey(SsoUser record);
    
    List<SsoUser> selectByCondition(SsoUser ssoUser);
}
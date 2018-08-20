package com.nnstn.sso.dao;

import com.nnstn.common.po.SsoLoginLog;

public interface SsoLoginLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SsoLoginLog record);

    int insertSelective(SsoLoginLog record);

    SsoLoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SsoLoginLog record);

    int updateByPrimaryKey(SsoLoginLog record);
}
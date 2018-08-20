package com.nnstn.sso.service;

import com.nnstn.common.po.SsoUser;
import com.nnstn.common.vo.CommonResult;

public interface RegisterService {
	CommonResult checkData(String param, int type);
	CommonResult register(SsoUser user);
}

package com.nnstn.common.vo;
/**
 * 自定义响应结构
 */
public class CommonResult {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static CommonResult ok() {
        return new CommonResult(200,"success",null);
    }
    public static CommonResult ok(Object data) {
    	return new CommonResult(200,"success",data);
    }
    public static CommonResult fail(Object data) {
    	return new CommonResult(500,"fail",null);
    }
    
    public static CommonResult build(Integer status, String msg) {
    	return new CommonResult(status, msg, null);
    }
	
    public static CommonResult build(Integer status, String msg, Object data) {
        return new CommonResult(status, msg, data);
    }
    
    private CommonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}

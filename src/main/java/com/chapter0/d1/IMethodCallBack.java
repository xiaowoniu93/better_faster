package com.chapter0.d1;

public interface IMethodCallBack {
	
	public String methodName();
	
	public DestBean callback(SourceBean sourceBean) throws Exception;

}

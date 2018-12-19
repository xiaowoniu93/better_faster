package com.chapter0.d1;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import net.sf.cglib.beans.BeanCopier;

public class CopyProcessor {

	private int count;
	
	public CopyProcessor(int count){
		this.count = count;
	}
	
	public void processor(IMethodCallBack methodCallBack, SourceBean sourceBean) throws Exception{
		long time1 = System.currentTimeMillis();
		DestBean destBean = null;
		for (int i = 0; i < count; i++) {
			destBean = methodCallBack.callback(sourceBean);
		}
		long time2 = System.currentTimeMillis();
		System.err.println(methodCallBack.methodName()+" 方法拷贝"+count+"次，耗时："+(time2-time1)+"ms");
		System.out.println(destBean);
	}
	
	// 手工拷贝
	static class ManualCopy implements IMethodCallBack{

		@Override
		public String methodName() {
			return "manual copy";
		}

		@Override
		public DestBean callback(SourceBean sourceBean) throws Exception {
			DestBean destBean = new DestBean();
			destBean.setPid(sourceBean.getPid());
			destBean.setUserId(sourceBean.getUserId());
			destBean.setProfit(sourceBean.getProfit());
			destBean.setActor(sourceBean.getActor());
			destBean.setShowDate(sourceBean.getShowDate());
			destBean.setTag(sourceBean.getTag());
			destBean.setMap(sourceBean.getMap());
			return destBean;
		}
	}
	
	// 动态代理拷贝
	static class Cglib implements IMethodCallBack{
		BeanCopier beanCopier = BeanCopier.create(SourceBean.class, DestBean.class, false);

		@Override
		public String methodName() {
			return "cglib";
		}

		@Override
		public DestBean callback(SourceBean sourceBean) throws Exception {
			DestBean destBean = new DestBean();
			beanCopier.copy(sourceBean, destBean, null);
			return destBean;
		}
	}
	
	// springbeanUtils
	static class SpringBeanUtils implements IMethodCallBack{

		@Override
		public String methodName() {
			return "SpringBeanUtils";
		}

		@Override
		public DestBean callback(SourceBean sourceBean) throws Exception {
			DestBean destBean = new DestBean();
			BeanUtils.copyProperties(sourceBean, destBean);
			return destBean;
		}
	}
	
	// ApachePropertiesUtils
	static class ApachePropertiesUtils implements IMethodCallBack{

		@Override
		public String methodName() {
			return "ApachePropertiesUtils";
		}

		@Override
		public DestBean callback(SourceBean sourceBean) throws Exception {
			DestBean destBean = new DestBean();
			PropertyUtils.copyProperties(destBean, sourceBean);
			return destBean;
		}
	}
	
	// ApacheBeanUtils
	static class ApacheBeanUtils implements IMethodCallBack{

		@Override
		public String methodName() {
			return "ApacheBeanUtils";
		}

		@Override
		public DestBean callback(SourceBean sourceBean) throws Exception {
			DestBean destBean = new DestBean();
			org.apache.commons.beanutils.BeanUtils.copyProperties(destBean, sourceBean);
			return destBean;
		}
	}
}

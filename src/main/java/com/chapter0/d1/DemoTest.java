package com.chapter0.d1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chapter0.d1.CopyProcessor.ApacheBeanUtils;
import com.chapter0.d1.CopyProcessor.ApachePropertiesUtils;
import com.chapter0.d1.CopyProcessor.Cglib;
import com.chapter0.d1.CopyProcessor.ManualCopy;
import com.chapter0.d1.CopyProcessor.SpringBeanUtils;

public class DemoTest {

	/**
	 * 拷贝属性 各方法性能测试
	 * @description 
	 * @date 2018年11月16日上午12:59:00
	 * @author xszheng
	 */
	public static void main(String[] args) throws Exception {
		SourceBean sourceBean = new SourceBean();
		sourceBean.setActor("徐峥");
		List<String> tag = new ArrayList<>();
		tag.add("喜剧");
		tag.add("爆笑");
		sourceBean.setTag(tag);
		sourceBean.setShowDate(new Date());

		CopyProcessor copyProcessor = new CopyProcessor(100);
		ManualCopy manualCopy = new ManualCopy();
		Cglib cglib = new Cglib();
		SpringBeanUtils springBeanUtils = new SpringBeanUtils();
		ApacheBeanUtils apacheBeanUtils = new ApacheBeanUtils();
		ApachePropertiesUtils apachePropertiesUtils = new ApachePropertiesUtils();
		
		copyProcessor.processor(manualCopy, sourceBean);
		copyProcessor.processor(cglib, sourceBean);
		copyProcessor.processor(springBeanUtils, sourceBean);
		copyProcessor.processor(apacheBeanUtils, sourceBean);
		copyProcessor.processor(apachePropertiesUtils, sourceBean);
	}

}

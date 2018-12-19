package com.chapter0.d1;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 源类
 * @author xszheng
 *
 */
public class SourceBean {

	private int pid;
	
	private Integer userId;
	
	private double profit;
	
	private String actor;
	
	private Date showDate;
	
	private List<String> tag;
	
	private Map<String, String> map;

	private String extendS;
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	public String getExtendS() {
		return extendS;
	}

	public void setExtendS(String extendS) {
		this.extendS = extendS;
	}

	@Override
	public String toString() {
		return "SourceBean [pid=" + pid + ", userId=" + userId + ", profit=" + profit + ", actor=" + actor
				+ ", showDate=" + showDate + ", tag=" + tag + ", map=" + map + ", extendS=" + extendS + "]";
	}
	
}

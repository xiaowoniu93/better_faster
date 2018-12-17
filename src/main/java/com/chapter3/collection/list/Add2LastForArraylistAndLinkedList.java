package com.chapter3.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较ArrayList和LinkedList 在末尾添加元素的性能差异
 * 1、5万次以下，LinkedList性能略高于ArrayList
 * 2、5万次以上，ArrayList性能高于LinkedList(指定堆越小后，差距越明显)
 * @author zhengxiaosun
 *
 */
public class Add2LastForArraylistAndLinkedList {
	
	public static void main(String[] args) {
		int count = 500000;
		add2LastForArrayList(count);
		add2LastForLinkedList(count);
	}

	public static void add2LastForArrayList(int count){
		List<Long> list = new ArrayList<Long>(count);
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			list.add(2222L);
		}
		long time2 = System.currentTimeMillis();
		System.err.println("add2LastForArraylist cost time:"+(time2 - time1));
	}
	
	public static void add2LastForLinkedList(int count){
		List<Long> list = new LinkedList<Long>();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			list.add(2222L);
		}
		long time2 = System.currentTimeMillis();
		System.err.println("add2LastForLinkedList cost time:"+(time2 - time1));
	}
}

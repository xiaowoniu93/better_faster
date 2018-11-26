package com.chapter3.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 增加指定元素到到指定下标
 * 比较ArrayList和LinkedList 的性能【LinkedList性能确实比ArrayList高】
 * @author zhengxiaosun
 *
 */
public class Add2RandomForArrayListAndLinkedList {

	public static void main(String[] args) {
		int count = 50000;
		add2RandomForArrayList(count);
		add2RandomForLinkedList(count);
	}
	
	public static void add2RandomForArrayList(int count){
		List<Integer> list = new ArrayList<>();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			list.add(0, 100);
		}
		long time2 = System.currentTimeMillis();
		System.out.println("arrayList add element to specified position, cost time="+(time2 - time1));
	}
	
	public static void add2RandomForLinkedList(int count){
		List<Integer> list = new LinkedList<>();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			list.add(0, 100);
		}
		long time2 = System.currentTimeMillis();
		System.out.println("linkedList add element to specified position, cost time="+(time2 - time1));
	}
}

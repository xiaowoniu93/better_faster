package com.chapter3.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分别从头部、尾部、中间删除元素，比较ArrayList和LinkedList的区别
 * List          头部          中间              尾部
 * ArrayList     800ms        500ms            3ms
 * LinkedList    5ms          3000ms           2ms
 * @author zhengxiaosun
 *
 */
public class RemoveForArrayListAndLinkedList {
	
	public static void main(String[] args) {
		int count = 100000;
		removeForArrayList(count);
		removeForLinkedList(count);
	}

	
	public static void removeForArrayList(int count){
		// 从头部删除元素
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time1 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(0);
		}
		long time2 = System.currentTimeMillis();
		System.out.println("arraylist 从头部删除元素耗时："+(time2 - time1));
		System.out.println("arraylist:"+list);
		
		// 从中间删除元素
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time3 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(list.size() >> 2);
		}
		long time4 = System.currentTimeMillis();
		System.out.println("arraylist 从中间删除元素耗时："+(time4 - time3));
		System.out.println("arraylist:"+list);
		
		// 从尾部删除元素
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time5 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(list.size() - 1);
		}
		long time6 = System.currentTimeMillis();
		System.out.println("arraylist 从尾部删除元素耗时："+(time6 - time5));
		System.out.println("arraylist:"+list);
	}
	
	
	public static void removeForLinkedList(int count){
		// 从头部删除元素
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time1 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(0);
		}
		long time2 = System.currentTimeMillis();
		System.err.println("LinkedList 从头部删除元素耗时："+(time2 - time1));
		System.out.println("linkedlist:"+list);
		
		// 从中间删除元素
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time3 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(list.size() >> 2);
		}
		long time4 = System.currentTimeMillis();
		System.err.println("LinkedList 从中间删除元素耗时："+(time4 - time3));
		System.out.println("linkedlist:"+list);
		
		// 从尾部删除元素
		for(int i = 0; i < count; i++){
			list.add(i);
		}
		long time5 = System.currentTimeMillis();
		while (list.size() > 0) {
			list.remove(list.size() - 1);
		}
		long time6 = System.currentTimeMillis();
		System.err.println("LinkedList 从尾部删除元素耗时："+(time6 - time5));
		System.out.println("linkedlist:"+list);
	}
}

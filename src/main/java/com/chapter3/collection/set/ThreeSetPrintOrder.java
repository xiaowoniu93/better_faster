package com.chapter3.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set是对Map的一种封装，HashSet对应HashMap，LinkedHashSet对应LinkedHashMap，TreeSet对应TreeMap
 * 三种主要set实现 输出元素顺序性比较
 * HashSet 输出顺序和输入顺序没有联系，即输出无序
 * LinkedHashSet 输出顺序和输入顺序一致
 * TreeSet 输出顺序默认递增排序
 * @author zhengxiaosun
 *
 */
public class ThreeSetPrintOrder {
	
	public static void main(String[] args){
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		Set<Integer> treeSet = new TreeSet<>();
		add(hashSet);
		add(linkedHashSet);
		add(treeSet);
		print(hashSet);
		print(linkedHashSet);
		print(treeSet);
	}
	

	public static void add(Set<Integer> set){
		set.add(100);
		set.add(40);
		set.add(70);
		set.add(90);
		set.add(10);
	}
	
	public static void print(Set<Integer> set){
		for(Iterator<Integer> iterator = set.iterator(); iterator.hasNext();){
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}

package com.chapter3.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * buffer 基础原理：属性capacity、position、limit的含义
 * @author zhengxiaosun
 *
 */
public class BufferBasicPrinciples {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		System.out.println("第一次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、15
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte)i);
		}
		System.out.println("第二次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、10、15
		byteBuffer.flip();
		System.out.println("第三次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、10
		for (int i = 0; i < 5; i++) {
			byteBuffer.get();
		}
		System.out.println("第四次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、5、10
		byteBuffer.clear();
		System.out.println("第五次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、15
	}
}

package com.chapter3.nio;

import java.nio.ByteBuffer;

/**
 * buffer 基础原理：属性capacity、position、limit的含义
 * @author zhengxiaosun
 *
 */
public class BufferBasicPrinciples {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(15);
		System.err.println(byteBuffer.hasRemaining()); // true (return position < limit)
		System.out.println("第一次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、15
		for (int i = 0; i < 10; i++) {
			byteBuffer.put((byte)i);
		}
		System.out.println("第二次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、10、15
		byteBuffer.flip();
		System.err.println(byteBuffer.hasRemaining()); // true
		System.out.println("第三次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、10
		while (byteBuffer.hasRemaining()) {
			byteBuffer.get();
		}
		System.out.println("第四次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、10、10
		byteBuffer.flip();
		System.out.println("第五次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、10
		byteBuffer.clear();
		System.err.println(byteBuffer.hasRemaining()); // true
		System.out.println("第六次：capacity="+byteBuffer.capacity()+", position="+byteBuffer.position()+", limit="+byteBuffer.limit()); // 15、0、15
		byte[] originByte = new byte[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t'};
		byteBuffer.put(originByte); // java.nio.BufferOverflowException
	}
}

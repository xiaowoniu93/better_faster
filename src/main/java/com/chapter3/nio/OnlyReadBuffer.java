package com.chapter3.nio;

import java.nio.ByteBuffer;

/**
 * 只读缓冲区
 * @author zhengxiaosun
 *
 */
public class OnlyReadBuffer {

	public static void main(String[] args) {
		ByteBuffer parentBuffer = ByteBuffer.allocate(15);
		for (int i = 0; i < 10; i++) {
			parentBuffer.put((byte)i);
		}
		ByteBuffer readBuffer = parentBuffer.asReadOnlyBuffer();
		readBuffer.flip();
		while (readBuffer.hasRemaining()) {
			System.out.print(readBuffer.get() + " ");
		}
		parentBuffer.put(2, (byte) 'a');
//		readBuffer.put(3, (byte)'b');	// 报异常 java.nio.ReadOnlyBufferException
		System.out.println();
		readBuffer.rewind();
		while (readBuffer.hasRemaining()) {
			System.out.print(readBuffer.get() + " ");
		}
	}
}

package com.chapter3.nio;

import java.nio.ByteBuffer;

/**
 * 缓存复制
 * @author zhengxiaosun
 *
 */
public class BufferDuplicate {
 
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		String firstContent = "abcdefgh";
		buffer.put(firstContent.getBytes());
		ByteBuffer buffer2 = buffer.duplicate();
		System.out.println("buffer:"+buffer);  // java.nio.HeapByteBuffer[pos=8 lim=15 cap=15]
		System.out.println("buffer2:"+buffer2); // java.nio.HeapByteBuffer[pos=8 lim=15 cap=15]
		buffer.flip();
		buffer2.flip();
		System.out.println("buffer:"+buffer);  // java.nio.HeapByteBuffer[pos=0 lim=8 cap=15]
		System.out.println("buffer2:"+buffer2); // java.nio.HeapByteBuffer[pos=0 lim=8 cap=15]
		byte[] writeByte = new byte[buffer.remaining()];
		buffer.get(writeByte);
		System.err.println("buffer:"+new String(writeByte)); // abcdefgh
		buffer2.get(writeByte);
		System.err.println("buffer2:"+new String(writeByte)); // abcdefgh
		
		buffer.put(0, (byte) 'z');
		
		buffer.rewind();
		buffer2.rewind();
		buffer.get(writeByte);
		System.err.println("buffer:"+new String(writeByte)); // zbcdefgh
		buffer2.get(writeByte);
		System.err.println("buffer2:"+new String(writeByte)); // zbcdefgh
		
	}
}

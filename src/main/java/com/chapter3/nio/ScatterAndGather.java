package com.chapter3.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散读取，聚集写入
 * @author xszheng
 *
 */
public class ScatterAndGather {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			FileOutputStream fos = new FileOutputStream("b.txt");
			FileChannel inChannel = fis.getChannel();
			FileChannel outChannel = fos.getChannel();
			ByteBuffer buf1 = ByteBuffer.allocate(10);
			ByteBuffer buf2 = ByteBuffer.allocate(1000);
			ByteBuffer[] bufs = { buf1, buf2 };
			inChannel.read(bufs);
			for (int i = 0; i < bufs.length; i++) {
				bufs[i].flip();
			}
			outChannel.write(bufs);
			inChannel.close();
			outChannel.close();
		} catch (Exception e) {
		}
	}

}

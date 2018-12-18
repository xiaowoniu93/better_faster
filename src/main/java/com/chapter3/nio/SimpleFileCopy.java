package com.chapter3.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileCopy {
	
	public static void main(String[] args) throws IOException{
		String sourceFile = "gradle项目启动_断点配置.rtf";
		String destFile = "gradle项目启动_断点配置V2.rtf";
		copyFile(sourceFile, destFile);
	}

	public static void copyFile(String sourceFile, String destFile) throws IOException{
		FileInputStream fis = new FileInputStream(new File(sourceFile));
		FileOutputStream fos = new FileOutputStream(new File(destFile));
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		while (true) {
			byteBuffer.clear();
			int r = readChannel.read(byteBuffer);
			if(r == -1){
				break;
			}
			byteBuffer.flip();
			writeChannel.write(byteBuffer);
		}
		readChannel.close();
		writeChannel.close();
	}
}

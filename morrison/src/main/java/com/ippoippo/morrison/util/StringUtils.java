package com.ippoippo.morrison.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringUtils {

	public static byte[] toBytes(InputStream is) {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte [] buffer = new byte[1024];
		try {
			while(true) {
				int len = is.read(buffer);
				if(len < 0) break;
				bout.write(buffer, 0, len);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return bout.toByteArray();
	}
}

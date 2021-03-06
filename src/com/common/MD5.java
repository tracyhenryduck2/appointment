package com.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cloopen.rest.sdk.utils.encoder.BASE64Encoder;

public class MD5 {
	public static String md5(String str) {
		String s2 = str;
		if (s2 == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null,
						ex);
			}
			BASE64Encoder baseEncoder = new BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s2.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}
}

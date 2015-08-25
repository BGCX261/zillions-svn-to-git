package cn.com.zillions.web;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String key = "zillions";

	public static String encrypt(String str) {

		byte[] enc = null;
		try {
			enc = desEncrypt(str, key);
		} catch (Exception ex) {
		}

		return new BASE64Encoder().encode(enc);
	}

	public static byte[] desEncrypt(String message, String key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(DEFAULT_ENCODING));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes(DEFAULT_ENCODING));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return cipher.doFinal(message.getBytes(DEFAULT_ENCODING));
	}

	public static byte[] _decrypt(byte[] message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(DEFAULT_ENCODING));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes(DEFAULT_ENCODING));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		return cipher.doFinal(message);

	}

	public static String decrypt(String str) throws Exception {

		byte[] enc = null;
		try {
			enc = _decrypt(new BASE64Decoder().decodeBuffer(str), key);
		} catch (Exception ex) {
		}

		return new String(enc, DEFAULT_ENCODING);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("5"));
		System.out.println(decrypt("mrhS8AVCFsg="));
	}
}
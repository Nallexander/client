/*
 * Common stuff
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

class CommonStuffClient {

    public static int DEFAULT_SOCKET_PORT = 3434;
    public static int DEFAULT_RMI_PORT = 3435;

    private static Properties prop = null;
    private static String stor_path = "";

    public static String hashString(String str)
		throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		String digest;

		md.update(str.getBytes());
		digest = bytesToString(md.digest());
		md.reset();

		return digest;
    }

    public static String bytesToString(byte[] bytearr) {
	StringBuffer sb = new StringBuffer(2 * bytearr.length);

	for (int i = 0; i < bytearr.length; i++) {
	    if (((int) bytearr[i] & 0xff) < 0x10)
		sb.append('0');
	    sb.append(Long.toString((int) bytearr[i] & 0xff, 16));
	    sb.append((i != bytearr.length - 1)?" ":"");
	}

	return (sb.toString()).toUpperCase();
    }
}

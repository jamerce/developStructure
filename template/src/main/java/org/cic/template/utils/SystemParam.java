package org.cic.template.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemParam {

	private static final SystemParam instance = new SystemParam();
	private static final String fileName = "system.properties";
	
	private Properties props = null;

	private SystemParam() {
		InputStream in = null;
		try {
			in = getResourceAsStream(fileName);
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			throw new RuntimeException(
					"Could not initialize SystemParam.  Cause: " + e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static String get(String key) {
		return (String) instance.props.get(key);
	}

	public static InputStream getResourceAsStream(String resource)
			throws IOException {
		InputStream in = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader != null)
			in = loader.getResourceAsStream(resource);
		if (in == null)
			in = ClassLoader.getSystemResourceAsStream(resource);
		if (in == null)
			throw new IOException("Could not find resource " + resource);
		return in;
	}
}

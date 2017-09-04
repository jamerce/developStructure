package org.cic.template.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class StreamGobbler extends Thread {
	final static org.apache.log4j.Logger log = Logger.getLogger(StreamGobbler.class);
	
	InputStream is;

	String type;

	public StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (type.equals("Error")){
					log.error(line);
				}else{
					log.debug(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

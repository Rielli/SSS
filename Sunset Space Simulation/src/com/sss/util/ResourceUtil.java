package com.sss.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResourceUtil {

	/**
	 * The path to the /res on the github repo :)
	 */
	private final static String resurl = "https://raw.githubusercontent.com/hdt80/SSS/master/Sunset%20Space%20Simulation/res/";

	
	/**
	 * Should never, <b>EVER</b> be initialized.
	 */
	private ResourceUtil() {

	}

	/**
	 * If someone cares to rewrite this i'll be happy
	 */
	public static void getResources() {
		/*
		 * Download filestofetch.txt
		 */
		download("filestofetch.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("res/filestofetch.txt")));
			String buff;
			ArrayList<String> readlines = new ArrayList<String>();
			
			while((buff = br.readLine()) != null){
				readlines.add(buff);
			}
			
			br.close();
			
			for(String s: readlines){
				download(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Downloads file from the provided directory
	 * @param str the path from the /res folder on the github repo :)
	 */
	private static void download(String str){
		URL url = null;
		try {
			/**
			 * Fetch URL and connection
			 */
			url = new URL(resurl + str);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			
			InputStream is;
			is = con.getInputStream();
			byte[] buffer = new byte[1024];
			File output = new File("res/" + str);
			int returni = 0;
			
			/*
			 * Ensure parent folder exists
			 */
			output.getParentFile().mkdirs();
			
			/*
			 * Download the file 
			 */
			FileOutputStream fos = new FileOutputStream(output);
			while((returni = is.read(buffer)) != -1){
				fos.write(buffer, 0, returni);
			}
			
			fos.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

package com.godoro.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StreamUtilities {

    public static String read(InputStream in) throws UnsupportedEncodingException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in,"utf-8"));
        String line;
        StringBuilder builder = new StringBuilder();
        while (( line=reader.readLine()) != null)  {
            builder.append(line).append("\r\n");
        }
        reader.close();
        String text = builder.toString();
        return text;
    }

    public static String get(String adress) throws Exception{
        URL url = new URL(adress);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        String text = read(in);
        return text;
    }

    public static void write(OutputStream out,String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(output);
        writer.flush();
        writer.close();
        out.flush();
        out.close();
    }
    
    public static String post(String address, String output) throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(address);	
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		StreamUtilities.write(connection.getOutputStream(),output);
		String input = StreamUtilities.read(connection.getInputStream());
		return input;
	}
}

package ru.o2genum.forvo.impl;

import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.EncoderException;
// http://commons.apache.org/codec/

import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import ru.o2genum.forvo.ApiKey;

public class ForvoNet {

	private static URLCodec codec = new URLCodec();

	public static String get(String action, Map<String, String> params)
    throws Exception {

		String apiKey = ApiKey.getKey();
        String host = ApiKey.getHost();
		// action
		String format = "json";

		StringBuilder sb = new StringBuilder();
		sb.append("http://" + host);
		sb.append("/key/" + apiKey);
		sb.append("/format/" + format);
		sb.append("/action/"+action);

		if(params != null) {
			for(String key: params.keySet()) {
				sb.append("/"+key+"/"+urlEncode(params.get(key)));
			}
		}

		StringBuilder sb2 = new StringBuilder();
		HttpURLConnection conn = null;

		URL url = new URL(sb.toString());
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			throw new Exception("Response is not HTTP_OK!");
		InputStream in = conn.getInputStream();
		Scanner sc = new Scanner(in);
		while(sc.hasNextLine()) {
			sb2.append(sc.nextLine());
		}
		conn.disconnect();

		return sb2.toString();
	}

	private static String urlEncode(String str) throws EncoderException {
		String s = "";
		s = codec.encode(str); 
		return s.replace("+", "%20");
	}
}

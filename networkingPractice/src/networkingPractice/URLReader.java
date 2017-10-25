package networkingPractice;

import java.net.*;
import java.io.*;

public class URLReader {

	    public static void main(String[] args) throws Exception {

	        URL oracle = new URL("https://outlook.live.com/owa/?realm=hotmail.com&path=/mail/inbox/rp");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));

	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	            System.out.println(inputLine);
	        }
	        in.close();
	    }
	}
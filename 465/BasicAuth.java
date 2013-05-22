package peterk.java.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.subject.Subject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicAuth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uname = "peterk";
		String passwd = "passwd8";
		String uname_passwd = uname + ":" + passwd;
		String protocol = "https";
		String host = "nagios002.lcsee.wvu.edu";
		String file = "/home/pkirkpat/.bash_aliases";
		URL url;

		System.out.println("getBytes: " + uname_passwd.getBytes());
		System.out.println("base64: enc " + Base64.encodeToString(uname_passwd.getBytes()));
		System.out.println("base64: dec " + Base64.decodeToString(Base64.encodeToString(uname_passwd.getBytes())));
		System.out.println("");
		
		UsernamePasswordToken authToken = new UsernamePasswordToken(uname, passwd);
		System.out.println("authToken: " + authToken.getPrincipal());
		System.out.println("authToken: " + authToken.getCredentials());
		
		authToken.setRememberMe(true);
		
		System.out.println("test: " + authToken.getPassword().toString());
		
//		Subject currentUser = SecurityUtils.getSubject();
//		System.out.println("currentUser: " + currentUser.getPrincipal().toString());
//		currentUser.login(authToken);

//		currentUser.logout();
//		authToken.clear();
		
		try {
			url = new URL(protocol + "://" + host);
  			try {
  				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  				conn.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(uname_passwd.getBytes()));
  				System.out.println("decode: " + Base64.encodeToString(uname_passwd.getBytes()));
  				System.out.println(conn.getHeaderFields());
  			} catch (IOException e) {
  				System.out.println("IOException");
  				e.printStackTrace();
  			}// end try/catch
		} catch (MalformedURLException e1) {
			System.out.println("MalformedURLException");
			e1.printStackTrace();
		}// end try/catch				
	}// end main
}// end BasicAuth

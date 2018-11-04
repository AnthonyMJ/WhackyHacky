package io.github.anthonymj.foodpointtech;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;

public class DatabaseHelper
{
	private String milkInline = "";
	private int _myresponsecode;

	public DatabaseHelper()
	 {


		 try {
			 //milk
			URL url = new URL("https://api.wegmans.io/products/categories/577-583?api-version=2018-10-18&subscription-key=1474d845d1ef473d9645da89d85320b0");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			String inline = "";
			
			int responsecode = con.getResponseCode();
			_myresponsecode = 777;
			if(responsecode != 200){
				throw new RuntimeException("HttpResponseCode: "+responsecode);
			}
			else{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()){
					inline+=sc.nextLine();
				}
				
				System.out.println(inline);
				milkInline = inline;
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			milkInline = e.toString();
		} catch (RuntimeException e){
			 milkInline = e.toString();
		}
	 }

	 public String getMilkInline(){
		return milkInline;
	 }
	 public int get_myresponsecode(){
		return _myresponsecode;
	 }
}
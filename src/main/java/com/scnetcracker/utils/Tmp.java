package com.scnetcracker.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Tmp
{
  public Tmp() {}
  
  public static JSONObject reques(String url) throws IOException
  {
    URL obj = new URL(url);
    HttpURLConnection connection = (HttpURLConnection)obj.openConnection();
    connection.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    int c;
    while ((c = in.read()) != -1)
    {
      response.append((char)c);
    }

    return new JSONObject(response.toString());
  }
}

package com.scnetcracker.parse;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class youtubeParse implements Parser
{
  public youtubeParse() {}
  
  public void parse(String channelId) throws java.io.IOException
  {
    String url = String.format("https://www.googleapis.com/youtube/v3/videos?id=%s&part=snippet&key=AIzaSyBUTzpbOCwYXhJSEBqKS1a7jO15GVjjt_k", new Object[] { channelId });
    



    URL obj = new URL(url);
    HttpURLConnection connection = (HttpURLConnection)obj.openConnection();
    
    connection.setRequestMethod("GET");
    
    BufferedReader in = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
    
    StringBuffer response = new StringBuffer();
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    
    JSONObject jsonObj = new JSONObject(response.toString());
    
    JSONObject json = (JSONObject)jsonObj.getJSONArray("items").get(0);
    
    json = (JSONObject)json.get("snippet");
    
    String desc = ((JSONObject)json.get("localized")).get("description").toString();
    
    System.out.println(desc);
  }
  
  public static void main(String[] args) throws java.io.IOException
  {
    youtubeParse youtube = new youtubeParse();
    
    youtube.parse("khKG0FdeHJo");
  }
}

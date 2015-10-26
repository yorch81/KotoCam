package com.kotorreo.cam;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yorch on 8/14/15.
 */
@SuppressWarnings("deprecation")
public class SaveCl {
    public  SaveCl(){

    }

    public int getId(){
		HttpClient httpclient = new DefaultHttpClient();
        String response = "";

        String url = "http://savein-japt.rhcloud.com/api/social/FB/10153407090311897";

        int retValue = 0;

        Logger logger = Logger.getLogger(SaveCl.class);
        
        try
        {
            HttpGet httpget = new HttpGet(url);
            HttpResponse httpResponse = httpclient.execute(httpget);

            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            //status = httpResponse.getStatusLine().getStatusCode();

            String line = "";
            while ((line = rd.readLine()) != null){
                response = response + line;
            }

            JSONObject jsonSocial =  new JSONObject(response);
            retValue = jsonSocial.getInt("ID");
        }
        catch (ClientProtocolException e){
        	logger.error(e.getMessage());
            //Log.e(LOGTAG, "ClientProtocolException", e);
            retValue = -1;
        }
        catch (IOException e){
        	logger.error(e.getMessage());
            //Log.e(LOGTAG, "IOException", e);
            retValue = -1;
        } catch (JSONException e) {
        	logger.error(e.getMessage());
            retValue = -1;
        }
        
        httpclient.getConnectionManager().shutdown();
        
        return retValue;
    }



}

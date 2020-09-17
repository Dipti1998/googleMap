package com.example.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MapServiceImpl implements MapService{

	@Override
	public String getAddress(double lat, double lng) {
		String key="AIzaSyBqOgf4wWH5ZPGPF9IKPu3LC-yDyWMs1DM";
        HttpGet httpGet = new HttpGet("https://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key=AIzaSyBqOgf4wWH5ZPGPF9IKPu3LC-yDyWMs1DM");
        @SuppressWarnings("resource")
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = client.execute(httpGet);
            System.out.println("response : "+response);
            HttpEntity entity = response.getEntity();
            System.out.println("entity : "+entity);
            InputStream stream = entity.getContent();
            System.out.println("stream : "+stream);
            
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
            } catch (IOException e) {
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode array = null;
		try {
			array = mapper.readValue(stringBuilder.toString(), JsonNode.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("array : "+array);
        JsonNode object = array.get("results").get(0);
        String reportKey = object.get("formatted_address").textValue();

        System.out.println("reportKey : "+reportKey);
		return reportKey;
	}


}

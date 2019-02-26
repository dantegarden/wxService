package com.bjdvt.wx;


import java.io.IOException;
import java.net.Proxy.Type;

import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonSyntaxException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IntegerDefault0Adapter  extends JsonDeserializer<Integer>{
	

	
	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		 try {
	            if ( p.getValueAsString().equals("") || p.getValueAsString().equals("null")) {//定义为int类型,如果后台返回""或者null,则返回0
	                return 0;
	            }
	        } catch (Exception ignore) {
	        }
	        try {
	            return p.getValueAsInt();
	        } catch (NumberFormatException e) {
	            throw new JsonSyntaxException(e);
	        }
	}

	
}

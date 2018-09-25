package com.bigdataconcept.microservice.event.common.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

import com.bigdataconcept.microservice.event.common.message.payload.DateDeserializer;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;




public interface ServiceHandler<T> {

    public MessageResponse processMessageRequestSync(String request);
    
    public void processMessageRequestAsync(String  request);
    

    public  T messageConverter(String messageJson) ;
	
	
        
	

    
    
    

}

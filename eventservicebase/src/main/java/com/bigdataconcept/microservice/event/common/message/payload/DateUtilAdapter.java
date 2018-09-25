package com.bigdataconcept.microservice.event.common.message.payload;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class DateUtilAdapter extends TypeAdapter<Date>{

    
    DateFormat dateFormater =   new SimpleDateFormat("yyyy-MM-dd");
	   

    @Override
    public Date read(JsonReader reader) throws IOException {
	// TODO Auto-generated method stub
	String date = reader.nextString();
	return null;
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
	// TODO Auto-generated method stub
	 out.value(dateFormater.format(value));
    }

}

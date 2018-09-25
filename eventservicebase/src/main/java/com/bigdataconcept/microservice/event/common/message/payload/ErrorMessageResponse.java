package com.bigdataconcept.microservice.event.common.message.payload;

import java.io.Serializable;

public class ErrorMessageResponse extends BaseResponse implements Serializable{

    
    private String stackMessage;
    
    public  ErrorMessageResponse(String msg)
    {
	this.stackMessage = msg;
    }

    public ErrorMessageResponse() {}
    public String getStackMessage() {
        return stackMessage;
    }

    public void setStackMessage(String stackMessage) {
        this.stackMessage = stackMessage;
    }
    
 
}

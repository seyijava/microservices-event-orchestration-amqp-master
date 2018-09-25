package com.bigdataconcept.microservice.event.common.message.payload;

public class ErrorResponse extends BaseResponse{

    
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}

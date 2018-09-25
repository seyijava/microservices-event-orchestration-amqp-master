package com.bigdataconcept.microservice.event.common.message.payload;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class MessageResponse implements Serializable{

    private String messageType;
    private String id = UUID.randomUUID().toString(); 
    private String traceId = UUID.randomUUID().toString(); 
    private String sender = "";
    private Date timestamp = new Date();
    private String correlationId; 
    private String serviceName;
    private String serviceAction;
    
    
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceAction() {
        return serviceAction;
    }

    public void setServiceAction(String serviceAction) {
        this.serviceAction = serviceAction;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private String createdBy;

  
    
    public MessageResponse() {    
    }
    
    
    
    @Override
    public String toString() {
      return "Message [messageType=" + messageType + ", id=" + id + ", timestamp=" + timestamp + ", correlationId=" + correlationId + "]";
    }

}

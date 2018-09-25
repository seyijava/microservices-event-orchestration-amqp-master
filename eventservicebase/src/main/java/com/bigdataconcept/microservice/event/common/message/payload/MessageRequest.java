package com.bigdataconcept.microservice.event.common.message.payload;

import java.util.Date;
import java.util.UUID;
import com.google.gson.annotations.JsonAdapter;;
public class MessageRequest {
    
    
    private String messageType;
    private String id = UUID.randomUUID().toString(); 
    private String traceId = UUID.randomUUID().toString(); 
    private String sender = "Shipping";
   
    @JsonAdapter(DateUtilAdapter.class)
    private Date timestamp = new Date();
    
    
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

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

   
    
    
    public MessageRequest() {    
    }
    
    

    public String getId() {
      return id;
    }

   
    public Date getTimestamp() {
      return timestamp;
    }

   

   
    public String getTraceId() {
      return traceId;
    }


    @Override
    public String toString() {
      return "Message [messageType=" + messageType + ", id=" + id + ", timestamp=" + timestamp + ", correlationId=" + correlationId + "]";
    }

}

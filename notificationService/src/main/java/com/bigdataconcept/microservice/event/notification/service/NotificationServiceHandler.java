package com.bigdataconcept.microservice.event.notification.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.bigdataconcept.microservice.event.common.message.payload.NotificatioReqeust;
import com.bigdataconcept.microservice.event.common.service.ServiceHandler;


@Component
public class NotificationServiceHandler implements ServiceHandler<NotificatioReqeust> {

    
    @Autowired
    NotificationService notificationService;
    @Override
    public MessageResponse processMessageRequestSync(String request) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void processMessageRequestAsync(String request) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public NotificatioReqeust messageConverter(String messageJson) {
	// TODO Auto-generated method stub
	return null;
    }

}

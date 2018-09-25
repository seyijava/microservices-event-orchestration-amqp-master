package com.bigdataconcept.microservice.event.bpmn.loan;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.amqp.adapter.producer.AmqpPublisher;
import com.bigdataconcept.microservice.event.amqp.adapter.producer.AmqpRpcClient;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauRequest;
import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;



@Component("notificationService")
public class NotificationActivity implements JavaDelegate {

 Logger logger = Logger.getLogger(NotificationActivity.class);
 
 
 public static final String SERVICE_ACTION = "notifiyAction";
    
    
 
    @Autowired
    AmqpPublisher amqpPublisher;
    
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
	// TODO Auto-generated method stub
	logger.info("NotificationActivity  Task Started");
	LoanApplicationReqeust sc = (LoanApplicationReqeust) execution.getVariable(ProcessConstants.VAR_CTX);
	MessageRequest messageRequest = new MessageRequest();
	
	messageRequest.setServiceName(ProcessConstants.SERVICE_NAME_NOTIFICATION);
	logger.info("NotificationActivity  Task completed\n\n");
    }

}

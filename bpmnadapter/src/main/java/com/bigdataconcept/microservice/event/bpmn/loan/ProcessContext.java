package com.bigdataconcept.microservice.event.bpmn.loan;

import java.io.Serializable;

import com.bigdataconcept.microservice.event.common.message.payload.ErrorMessageResponse;
import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;

public class ProcessContext implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    
        private LoanApplicationReqeust response;

	public LoanApplicationReqeust getResponse() {
		return response;
	}

	public void setResponse(LoanApplicationReqeust response) {
		this.response = response;
	}

	public ErrorMessageResponse getError() {
		return error;
	}

	public void setError(ErrorMessageResponse error) {
		this.error = error;
	}

	private ErrorMessageResponse error;

}

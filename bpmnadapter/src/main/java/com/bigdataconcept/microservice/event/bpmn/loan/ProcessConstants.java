package com.bigdataconcept.microservice.event.bpmn.loan;

public final class ProcessConstants {
    
    
    public static final String PROCESS_KEY_SUBMIT_LOAN_REQ = "submitLoanReq";

	public static final String VAR_CTX = "context";
	public static final String VAR_SC_ID = "shoppingCartId";
	public static final String VAR_ADDRESS = "address";
	public static final String VAR_PAYMENT = "payment";
	public static final String VAR_LR= "shoppingCart";
	public static final String VAR_PRODUCT = "product";
	public static final String VAR_RESPONSE = "response";
	public static final String VAR_PAYMENT_RESERVED = "paymentReserved";
	public static final String VAR_INVENTORY_ALLOCATED = "inventoryAllocated";
	public static final String VAR_ORDER_PLACED = "orderPlaced";

	
	
	
	public static final String SERVICE_NAME_CREDITBUREAU = "CreditBureauService";
	public static final String SERVICE_NAME_FEECALCULATION = "FeeCalculationService";
	
	
	public static final String SERVICE_NAME_LOANPROCESSOR = "InventoryService";
	public static final String SERVICE_NAME_NOTIFICATION = "NotificationService";
	

	public static final String ENTITY_TYPE_SHOPPINGCART = "SHOPPINGCART";
	public static final String ENTITY_TYPE_LOCATION = "LOCATION";
	public static final String ENTITY_TYPE_PAYMENT = "PAYMENT";
	public static final String ENTITY_TYPE_PRODUCT = "PRODUCT";
	public static final String ENTITY_TYPE_ERROR = "ERROR";

	public static final String SC_STATUS_OPEN = "OPEN";
	public static final String SC_STATUS_CLOSED = "CLOSED";

	public static final String UNKNOWN = "UNKNOWN";

	private ProcessConstants() {
	}

}

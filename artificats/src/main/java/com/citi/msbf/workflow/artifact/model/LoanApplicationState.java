package com.citi.msbf.workflow.artifact.model;

public enum LoanApplicationState {
	 
	APPLICATION_SUBMITTED("submitted"),
	APPLICATION_ACCEPTED("accepted");
	
	private String state;
	
	
	private LoanApplicationState(String state){
		this.state = state;
	}
	
	public String getState(){
		return state;
	}
}

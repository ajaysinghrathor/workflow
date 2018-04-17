package com.citi.msbf.workflow.artifact.model;

public enum LoanApplicationState {
	 
	APPLICATION_SUBMITTED("Submitted"),
	APPLICATION_ACCEPTED("Accepted");
	
	private String state;
	
	
	private LoanApplicationState(String state){
		this.state = state;
	}
	
	public String getState(){
		return state;
	}
}

package com.citi.msbf.workflow.artifact.model;

public enum ProcessInitiatorType {
	CLINET("client"),
	BANKER("banker");
	
	private String initiator;
	private ProcessInitiatorType(String initiator){
		this.initiator = initiator;
	}
	
	public String getInitiator(){
		return initiator;
	}
}

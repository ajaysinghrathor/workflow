package com.citi.msbf.workflow.artifact.model;

import java.util.Date;

public class ProcessData {
	
	private String processId;
	private String processName;
	private String correlationKey;
	private String initiatorType;
	private String processInitiatedBy;
	private Date processInitiatedDate;
	
	public ProcessData(String processId, String processName,
			String correlationKey,ProcessInitiatorType initiatorType,
			String processInitiatedBy,Date processInitiatedDate) {
		this.processId = processId;
		this.processName = processName;
		this.correlationKey = correlationKey;
		this.initiatorType = initiatorType.getInitiator();
		this.processInitiatedBy = processInitiatedBy;
		this.processInitiatedDate = processInitiatedDate;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getCorrelationKey() {
		return correlationKey;
	}

	public void setCorrelationKey(String correlationKey) {
		this.correlationKey = correlationKey;
	}

	public String getProcessInitiatedBy() {
		return processInitiatedBy;
	}

	public void setProcessInitiatedBy(String processInitiatedBy) {
		this.processInitiatedBy = processInitiatedBy;
	}

	public Date getProcessInitiatedDate() {
		return processInitiatedDate;
	}

	public void setProcessInitiatedDate(Date processInitiatedDate) {
		this.processInitiatedDate = processInitiatedDate;
	}

	public String getInitiatorType() {
		return initiatorType;
	}

	public void setInitiatorType(String initiatorType) {
		this.initiatorType = initiatorType;
	}

}

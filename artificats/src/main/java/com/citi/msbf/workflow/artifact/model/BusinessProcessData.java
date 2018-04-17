package com.citi.msbf.workflow.artifact.model;


public class BusinessProcessData {
	private LoanData loanData;
	private ProcessData processData;

	
	public BusinessProcessData(LoanData loanData, ProcessData processData) {
		this.loanData = loanData;
		this.processData = processData;
	}

	public LoanData getLoanData() {
		return loanData;
	}

	public void setLoanData(LoanData loanData) {
		this.loanData = loanData;
	}

	public ProcessData getProcessData() {
		return processData;
	}

	public void setProcessData(ProcessData processData) {
		this.processData = processData;
	}

}

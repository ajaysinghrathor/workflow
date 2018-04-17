package com.citi.msbf.workflow.artifact.model;

import java.util.Date;

public class LoanData {

	private Long loanApplicationId;
	private String loanApplicationState;
	private Date submitDate;
	private Date accepttedDate;
	
	public LoanData(Long loanApplicationId, 
			LoanApplicationState loanApplicationState,
			Date submitDate, Date accepttedDate) {
		this.loanApplicationId = loanApplicationId;
		this.loanApplicationState = loanApplicationState.getState();
		this.submitDate = submitDate;
		this.accepttedDate = accepttedDate;
	}

	public Long getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(Long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getAcceptanceDate() {
		return accepttedDate;
	}

	public void setAcceptanceDate(Date acceptanceDate) {
		this.accepttedDate = acceptanceDate;
	}

	public String getLoanApplicationState() {
		return loanApplicationState;
	}

	public void setLoanApplicationState(String loanApplicationState) {
		this.loanApplicationState = loanApplicationState;
	}

	public Date getAccepttedDate() {
		return accepttedDate;
	}

	public void setAccepttedDate(Date accepttedDate) {
		this.accepttedDate = accepttedDate;
	}
	
}

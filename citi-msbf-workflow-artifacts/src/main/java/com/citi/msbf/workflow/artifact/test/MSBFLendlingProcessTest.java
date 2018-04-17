package com.citi.msbf.workflow.artifact.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;

import com.citi.msbf.workflow.artifact.model.BusinessProcessData;
import com.citi.msbf.workflow.artifact.model.LoanApplicationState;
import com.citi.msbf.workflow.artifact.model.LoanData;
import com.citi.msbf.workflow.artifact.model.ProcessData;
import com.citi.msbf.workflow.artifact.model.ProcessInitiatorType;

public class MSBFLendlingProcessTest extends BaseTest{

	@Override
	public String[] processesToLoad() {
		String basePath = "\\com\\citi\\"
				+ "lending\\msbf\\workflow\\process\\flow\\";
		String msbfFlow = basePath + "1-msbfLendlingProcess.bpmn2";
		String clientFlow = basePath + "3.ClientLoanLendingProcess.bpmn2";
		String[] processes = {msbfFlow, clientFlow};
		return processes;
	}

	@Test
	public void testTriggerMSBFLendingProcess(){
		RuntimeManager runtimeManager = createRuntimeManager(processesToLoad());
		RuntimeEngine runtimeEngine = runtimeManager.getRuntimeEngine(null);
		KieSession ksession = runtimeEngine.getKieSession();
		
		Map<String, Object> params = new HashMap<String, Object>();
		LoanData loanData = new LoanData(1234L,
				LoanApplicationState.APPLICATION_SUBMITTED,
				new Date(), new Date());

		ProcessData processData = new ProcessData("processID", "processName",
				"correlationKey", ProcessInitiatorType.CLINET, "Client",
				new Date());

		BusinessProcessData businessProcessData = new BusinessProcessData(
				loanData, processData);
		params.put("businessProcessData", businessProcessData);
		String processID = "com.citi.msbf.workflow."
				+ "process.flow.msbfLoanLendingProcess";
		ksession.startProcess(processID, params);
	}

	@Test
	public void testTriggerClientLoanLendingProcess(){

		RuntimeManager runtimeManager = createRuntimeManager(processesToLoad());
		RuntimeEngine runtimeEngine = runtimeManager.getRuntimeEngine(null);
		KieSession ksession = runtimeEngine.getKieSession();

		Map<String, Object> params = new HashMap<String, Object>();
		LoanData loanData = new LoanData(1234L,
				LoanApplicationState.APPLICATION_SUBMITTED,
				new Date(), new Date());

		ProcessData processData = new ProcessData("processID", "processName",
				"correlationKey", ProcessInitiatorType.CLINET, "Client",
				new Date());

		BusinessProcessData businessProcessData = new BusinessProcessData(
				loanData, processData);
		params.put("businessProcessData", businessProcessData);
		String processID = "com.citi.msbf.workflow.process.flow."
				+ "clientLoanLendingProcess";
		ksession.startProcess(processID, params);
	}
}

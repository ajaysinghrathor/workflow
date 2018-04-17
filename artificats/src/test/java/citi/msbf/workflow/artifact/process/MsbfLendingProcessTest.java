package citi.msbf.workflow.artifact.process;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.citi.msbf.workflow.artifact.model.BusinessProcessData;
import com.citi.msbf.workflow.artifact.model.LoanApplicationState;
import com.citi.msbf.workflow.artifact.model.LoanData;
import com.citi.msbf.workflow.artifact.model.ProcessData;
import com.citi.msbf.workflow.artifact.model.ProcessInitiatorType;

public class MsbfLendingProcessTest extends BaseTest{

	@Override
	public String[] processesToLoad() {
		String basePath = "\\";
		String msbfFlow = basePath + "1-MSBFLendingProcess.bpmn2";
		String clientFlow = basePath + "2-ClientLoanLendingProcess.bpmn2";
		String bankerFlow = basePath + "3-BankerLoanLendingProcess.bpmn2";
		String attestationFlow = basePath + "4-CheckAttestationProcess.bpmn2";
		String currentKycFlow = basePath + "5-CheckCurrentKYCProcess.bpmn2";
		String publicFigureFlow = basePath + "6-CheckSeniorPublicFigureProcess.bpmn2";
		String[] processes = {msbfFlow,clientFlow,bankerFlow,attestationFlow,
				currentKycFlow,publicFigureFlow};
		return processes;
	}

	@Test
	public void testTriggerMSBFLendingProcess_GivenInitiatorAsClient_ShouldTriggerClientLendingProcess(){
		
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
		String processID = "com.citi.msbf.workflow.artifact.process.MSBFLendingProcess";
		ksession.startProcess(processID, params);
	}
	
	@Test
	public void testTriggerMSBFLendingProcess_GivenInitiatorAsBanker_ShouldTriggerBankerLendingProcess(){
		Map<String, Object> params = new HashMap<String, Object>();
		LoanData loanData = new LoanData(1234L,
				LoanApplicationState.APPLICATION_SUBMITTED,
				new Date(), new Date());

		ProcessData processData = new ProcessData("processID", "processName",
				"correlationKey", ProcessInitiatorType.BANKER, "Banker",
				new Date());

		BusinessProcessData businessProcessData = new BusinessProcessData(
				loanData, processData);
		params.put("businessProcessData", businessProcessData);
		String processID = "com.citi.msbf.workflow.process.BankerLoanLendingProcess";
		ksession.startProcess(processID, params);
	}
	
	@Test
	public void testTriggerMSBFLendingProcess_GivenNullBusinessProcessData_ThenShouldLogException(){
		
	}
}

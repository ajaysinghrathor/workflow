package buisness.process.flow;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.process.workitem.bpmn2.ServiceTaskHandler;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieContext;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;

import com.citi.msbf.workflow.artifact.model.BusinessProcessData;
import com.citi.msbf.workflow.artifact.model.LoanApplicationState;
import com.citi.msbf.workflow.artifact.model.LoanData;
import com.citi.msbf.workflow.artifact.model.ProcessData;
import com.citi.msbf.workflow.artifact.model.ProcessInitiatorType;

public class LoanLendingBusinessProcessTest extends JbpmJUnitBaseTestCase{

	private KieSession ksession;
	private KieContext kContext; 
	private RuntimeEngine runtimeEngine;
	private RuntimeManager runtimeManager;
	
	@Before
	public void setup(){
		runtimeManager = createRuntimeManager("buisness/process/flow/loanLendingProcess.bpmn2",
				"buisness/process/flow/sample1.bpmn2",
				"buisness/process/flow/process-loanApplication-main.bpmn2",
				"buisness/process/flow/start-signal.bpmn2",
				"buisness/process/flow/serviceTest.bpmn2");
		runtimeEngine = runtimeManager.getRuntimeEngine(null);
		ksession = runtimeEngine.getKieSession();
	}
	
	@Test
	public void testLoanLendingBusinessProcess(){
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
		
		//ksession.setGlobal("globalMessage", "hello Ajay...");
		
		params.put("message", "hello Ajay...");
		
		
		ksession.startProcess("com.msbf.lending.workflow.loanLendingProcess",
				params);
	}
	
	@Test
	public void testStartProcessBySignalEvent(){
		
		ProcessInstance processInstance = ksession.
				startProcess("business.process.flow.start-signal");
		//ksession.signalEvent("Signal", "START", processInstance.getId());
		/*assertNotNull("Process should be started", processInstance);
		System.out.println("Process Name = " + 
		processInstance.getProcessName());*/
	}
	
	@Test
	public void testServiceTask(){
		
		
		//ksession.getWorkItemManager().registerWorkItemHandler("test", new ServiceTaskHandler());
		
		ksession.startProcess("business.process.flow.serviceTest");
	}
}

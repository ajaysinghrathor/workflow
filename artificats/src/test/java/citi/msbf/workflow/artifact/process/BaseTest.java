package citi.msbf.workflow.artifact.process;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Before;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;

public abstract class BaseTest extends JbpmJUnitBaseTestCase{
	
	protected KieSession ksession;
	private RuntimeEngine runtimeEngine;
	private RuntimeManager runtimeManager;
	
	public abstract String[] processesToLoad();
	
	@Before
	public void setup(){
		runtimeManager = createRuntimeManager(processesToLoad());
		runtimeEngine = runtimeManager.getRuntimeEngine(null);
		ksession = runtimeEngine.getKieSession();
	}
	
}

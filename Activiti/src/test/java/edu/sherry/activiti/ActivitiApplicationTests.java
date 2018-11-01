package edu.sherry.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiApplicationTests {


    private ProcessEngine processEngine;

    @Before
    public void init(){
        processEngine = ProcessEngines.getDefaultProcessEngine();

    }

	@Test
	public void deploy() {
        processEngine.getRepositoryService().createDeployment()
        .name("deploy hello world")
        .addClasspathResource("diagrams/helloWorld.bpmn")
        .deploy();
    }

    @Test
    public void deployQuery(){
        Deployment result = processEngine.getRepositoryService()
                .createDeploymentQuery()
                .deploymentId("1")
                .singleResult();
        System.out.println(result.getName());
    }

}

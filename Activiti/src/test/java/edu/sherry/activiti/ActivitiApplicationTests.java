package edu.sherry.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        .addClasspathResource("diagrams/processVariables.bpmn")
        .deploy();
    }
    /**
     * 启动流程
     */
    @Test
    public void start(){
        ProcessInstance instance = processEngine.getRuntimeService().startProcessInstanceById("processVariables:1:10004");
        System.out.println(instance.getId());
        System.out.println(instance.getProcessDefinitionId());
    }

    @Test
    public void query(){
        List<Task> list = processEngine.getTaskService().createTaskQuery()
                .taskAssignee("王五")
                .list();
        list.forEach(task -> {
            System.out.println(task.getAssignee());
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getTaskLocalVariables().size());
        });
    }

    @Test
    public void complete(){
        Map<String, Object> param = new HashMap<>();
        processEngine.getTaskService().complete("20002");
    }

    @Test
    public void deployQuery(){
        Deployment result = processEngine.getRepositoryService()
                .createDeploymentQuery()
                .deploymentId("1")
                .singleResult();
        System.out.println(result.getName());
    }

    @Test
    public void setVariables(){
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", "tom");
        variables.put("age", "12");
        variables.put("reason", "something");
        taskService.setVariables("15004", variables);
    }

    @Test
    public void getVariables(){
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> variables = taskService.getVariables("20002");
        System.out.println(variables.toString());
    }

    @Test
    public void handleVariables(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();

    }
}

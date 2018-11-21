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
        .name("Parallel Gateway Demo")
        .addClasspathResource("diagrams/parallelGateway.bpmn")
        .deploy();
    }
    /**
     * 启动流程
     */
    @Test
    public void start(){
        Map<String, Object> variables = new HashMap<>();
        variables.put("userId1", "100");
        variables.put("userId2", "200");
        ProcessInstance instance = processEngine.getRuntimeService()
                .startProcessInstanceById("ParallelGatewayDemo:1:32504", variables);
        System.out.println(instance.getId());
        System.out.println(instance.getProcessDefinitionId());
    }

    @Test
    public void query(){
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee("100")
                .list();
        list.forEach(task -> {
            System.out.println(task.getProcessVariables());
            System.out.println(task.getAssignee());
            System.out.println(task.getId());
            System.out.println(taskService.getVariables(task.getId()));
            System.out.println(task.getName());
            System.out.println(task.getTaskLocalVariables());
        });
    }

    @Test
    public void complete(){
        processEngine.getTaskService().complete("40003");
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
        variables.put("type", "2");
        variables.put("name", "im tom");
        taskService.setVariables("15004", variables);
    }

    @Test
    public void getVariables(){
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> variables = taskService.getVariables("10003");
        System.out.println(variables.toString());
    }

    @Test
    public void handleVariables(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
    }
}

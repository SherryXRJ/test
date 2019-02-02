package pers.sherry.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.Deployment;
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
        .name("subProcess.bpmn")
        .addClasspathResource("diagrams/subProcess.bpmn")
        .deploy();
    }
    /**
     * 启动流程
     */
    @Test
    public void start(){
        Map<String, Object> variables = new HashMap<>();
        variables.put("type", 2);
        ProcessInstance instance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("subProcess", variables);
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
        processEngine.getTaskService().complete("72504");
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
    public void queryHistory(){
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId("2501")
                .list();
        list.forEach(history -> System.out.println(history.getActivityName()));
    }

    @Test
    public void claim(){
        processEngine.getTaskService()
                .claim("60009", "aa");
    }
}

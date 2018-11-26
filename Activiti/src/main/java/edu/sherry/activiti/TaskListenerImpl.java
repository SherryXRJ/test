package edu.sherry.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerImpl implements TaskListener{

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("listenUser");
        System.out.println("TaskListenerImpl...");
    }
}

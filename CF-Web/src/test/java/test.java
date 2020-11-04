import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {

    }
           @Test
        public void test02 () {
               ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                       .createProcessEngineConfigurationFromResource("activiti.xml");
               //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
               ProcessEngine processEngine =
                       configuration.buildProcessEngine();
//
            RepositoryService repositoryService = processEngine.getRepositoryService();
            Deployment deploy = repositoryService.createDeployment().addClasspathResource("t1.bpmn").deploy();
            ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
//        ProcessDefinitionQuery processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery().latestVersion();
//        List<ProcessDefinition> list = processDefinition.list();

//            HashMap<String, Object> map = new HashMap<>();
//            map.put("yesLsn", new YesListener());
//            map.put("noLsn", new NoListener());
            ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("Process_1x6aczi");
//        TaskService taskService = processEngine.getTaskService();
//        TaskQuery taskQuery = taskService.createTaskQuery();
//        List<Task> z3 = taskQuery.taskAssignee("z3").list();
//        for (Task task : z3) {
//            taskService.setVariable(task.getId(),"flag","false");
//            taskService.complete(task.getId());
//        }
        }

    @Test
      public void test1(){

           ApplicationContext ioc= new ClassPathXmlApplicationContext("mail.xml");
        MailSender mailSender = (MailSender) ioc.getBean("mailSender");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("test@my.com");
        simpleMailMessage.setFrom("admin@my.com");
        simpleMailMessage.setSubject("im subject");
        simpleMailMessage.setText("im test");
mailSender.send(simpleMailMessage);
    }

    @Test
    public void test03(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("res","a");
        objectObjectHashMap.put("res","b");
        System.out.println(objectObjectHashMap);
    }
}
